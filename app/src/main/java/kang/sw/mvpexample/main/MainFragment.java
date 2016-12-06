package kang.sw.mvpexample.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import kang.sw.mvpexample.R;
import kang.sw.mvpexample.utils.ActivityUtils;
import kang.sw.mvpexample.utils.Utils;
import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.common.testing.LogFragment;
import kang.sw.mvpexample.utils.mvp.BasePresenter;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */

public class MainFragment
    extends LogFragment
    implements MainFragPresenterImpl.View {
  private static final String TAG = MainFragment.class.getSimpleName();

  private MainFragPresenterImpl presenter;

  @BindView(R.id.main_frag_tv)        TextView tvMain;
  @BindView(R.id.main_frag_btn_plus)  Button   btnPlus;
  @BindView(R.id.main_frag_btn_minus) Button   btnMinus;

  public static MainFragment newInstance(@Nullable Bundle args) {
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public <P extends BasePresenter> void setPresenterToChild(P presenter) {
    if (presenter instanceof MainFragPresenterImpl) {
      this.presenter = (MainFragPresenterImpl) presenter;
    }
  }

  @Override
  public int getLayoutResId() {
    return R.layout.main_frag_default;
  }

  @OnClick({R.id.main_frag_btn_plus, R.id.main_frag_btn_minus})
  void onClickButtons(View view) {
    if (view != null) {
      btnMinus.setEnabled(false);
      btnPlus.setEnabled(false);
      if (view.getId() == R.id.main_frag_btn_plus) {
        presenter.plusCounterValue();
      }
      else if (view.getId() == R.id.main_frag_btn_minus) {
        presenter.minusCounterValue();
      }
    }
  }

  @Override
  public void onError(@NonNull String tag, @Nullable Object obj) {
    super.onError(tag, obj);

    if (obj instanceof String) {
      Utils.showToast(getActivity(), (String) obj);
    }
  }

  @Override
  public void updateCounterValue(int counterValue) {
    SwLog.d(TAG, "// updateCounterValue() // value = " + counterValue);
    tvMain.setText(String.valueOf(counterValue));
    btnPlus.setEnabled(true);
    btnMinus.setEnabled(true);
  }

}
