package kang.sw.mvpexample.utils.common;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import kang.sw.mvpexample.utils.mvp.BasePresenter;
import kang.sw.mvpexample.utils.mvp.RxPresenter;
import kang.sw.mvpexample.utils.mvp.BaseView;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public abstract class BaseFragment
    extends Fragment
    implements BaseView {
  private RxPresenter rxPresenter;
  private Unbinder    unbinder;

  // - - Abstract methods  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  public abstract <P extends BasePresenter> void setPresenterToChild(P presenter);

  @LayoutRes
  public abstract int getLayoutResId();

  // - - Life cycle methods  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Retain this fragment across configuration changes.
    setRetainInstance(true);
  }

  @CallSuper
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutResId(), container, false);
    unbinder = ButterKnife.bind(this, view);
    onCreatedView(view, savedInstanceState);
    return view;
  }

  public void onCreatedView(@Nullable View inflatedView, @Nullable Bundle savedInstanceState) {
  }

  @Override
  public void onResume() {
    super.onResume();
    if (rxPresenter != null) {
      rxPresenter.onStart();
    }
  }

  @CallSuper
  @Override
  public void onDestroy() {
    beforeDestroy();
    if (rxPresenter != null) {
      rxPresenter.destroy();
    }
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroy();
  }

  public void beforeDestroy() {
  }

  // - - Implements methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Override
  public <P extends BasePresenter> void setPresenter(P presenterImpl) {
    this.rxPresenter = (RxPresenter) presenterImpl;
    setPresenterToChild(rxPresenter);
  }

  @Override
  public void onError(@NonNull String tag, @Nullable Object obj) {
    StringBuilder builder = new StringBuilder("ERROR : ");
    if (obj instanceof String) {
      builder.append((String) obj);
    }
    else if (obj instanceof CharSequence) {
      builder.append((CharSequence) obj.toString());
    }
    else if (obj instanceof Throwable) {
      builder.append(((Throwable) obj).getMessage());
    }
    else {
      if (obj != null) {
        builder.append(String.valueOf(obj.getClass().getSimpleName()));
      }
      else {
        builder.append("receive object is Null.");
      }
    }
    SwLog.e(tag, builder.toString());
  }

  // - - Common methods - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


}
