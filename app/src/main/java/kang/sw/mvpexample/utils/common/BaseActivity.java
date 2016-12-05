package kang.sw.mvpexample.utils.common;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;

import butterknife.ButterKnife;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public abstract class BaseActivity
    extends AppCompatActivity {
  private static final int MIN_KEYBOARD_HEIGHT = 150;

  private View decorView;
  private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

  // - - Abstract methods  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @LayoutRes
  public abstract int getLayoutResId();

  // - - Life cycle methods  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @CallSuper
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(getLayoutResId());
    ButterKnife.bind(this);
  }

  @CallSuper
  @Override
  protected void onDestroy() {
    super.onDestroy();
    if(decorView != null && globalLayoutListener != null) {
      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        decorView.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
      }
      else {
        decorView.getViewTreeObserver().removeGlobalOnLayoutListener(globalLayoutListener);
      }
    }
  }

  // - - Implements methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  // - - Common methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  final public void checkSoftKeyboardVisible(@Nullable final OnSoftKeyboardVisibility keyboardVisibilityListener) {
    decorView = getWindow().getDecorView();
    globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
      private final Rect windowVisibleDisplayFrame = new Rect();
      private int lastVisibleDecorViewHeight;

      @Override
      public void onGlobalLayout() {
        // 보여지고 있는 window의 크기를 사각형 Rect객체로 가져 온다.
        decorView.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame);
        final int visibleDecorViewHeight = windowVisibleDisplayFrame.height();

        // 보여지고 있는 높이의 계산 결과에 따라 키보드의 등장 유무를 확인 한다.
        if (lastVisibleDecorViewHeight != 0) {
          if (lastVisibleDecorViewHeight > visibleDecorViewHeight + MIN_KEYBOARD_HEIGHT) {
            final int currentKeyboardHeight = decorView.getHeight() - windowVisibleDisplayFrame.bottom;
            // 키보드가 등장중인 상태
            if (keyboardVisibilityListener != null) {
              keyboardVisibilityListener.onSoftKeyboardShown(currentKeyboardHeight);
            }
          }
          else if (lastVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT < visibleDecorViewHeight) {
            // 키보드가 사라진 상태
            if (keyboardVisibilityListener != null) {
              keyboardVisibilityListener.onSoftKeyboardHide();
            }
          }
        }
        lastVisibleDecorViewHeight = visibleDecorViewHeight;
      }
    };
    decorView.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
  }

}
