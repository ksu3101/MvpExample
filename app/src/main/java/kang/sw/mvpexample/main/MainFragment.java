package kang.sw.mvpexample.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import kang.sw.mvpexample.R;
import kang.sw.mvpexample.repository.example.UserConstant;
import kang.sw.mvpexample.repository.example.UserInfo;
import kang.sw.mvpexample.utils.Utils;
import kang.sw.mvpexample.utils.common.BaseFragment;
import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.mvp.presenters.BasePresenter;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class MainFragment
    extends BaseFragment
    implements MainFragmentPresenter.View {
  private static final String TAG = MainFragment.class.getSimpleName();

  @Inject MainFragmentPresenter presenter;

  @BindView(R.id.main_frag_tv)        TextView tvMain;
  @BindView(R.id.main_frag_btn_plus)  Button   btnPlus;
  @BindView(R.id.main_frag_btn_minus) Button   btnMinus;

  public static MainFragment newInstance(@Nullable Bundle args) {
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void setPresenter(@NonNull BasePresenter presenter) {
    super.setPresenter(presenter);
    if (presenter instanceof MainFragmentPresenter) {
      this.presenter = (MainFragmentPresenter) presenter;
    }
  }

  @Override
  public int getLayoutResId() {
    return R.layout.main_frag_default;
  }

  @Override
  public void onResume() {
    super.onResume();
    if(presenter != null) {
      presenter.exampleFunc2(UserConstant.USER_JSON_01);
      presenter.exampleFunc2(UserConstant.USER_JSON_02);
    }
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
    SwLog.i(TAG, "// updateCounterValue() // value = " + counterValue);
    tvMain.setText(String.valueOf(counterValue));
    btnPlus.setEnabled(true);
    btnMinus.setEnabled(true);
  }

  @Override
  public void resultOfJsonParsed(@Nullable UserInfo userInfo) {
    if(userInfo != null) {
      Log.d(TAG, "// received UserInfo object = " + userInfo.toString());
    }
    else {
      Log.e(TAG, "// parse UserInfo failed.. received object is Null.");
    }
  }
}
