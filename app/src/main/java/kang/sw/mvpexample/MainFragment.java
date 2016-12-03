package kang.sw.mvpexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kang.sw.mvpexample.utils.common.BaseFragment;
import kang.sw.mvpexample.utils.mvp.BasePresenter;
import kang.sw.mvpexample.utils.mvp.RxPresenter;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */

public class MainFragment
    extends BaseFragment
    implements MainFragPresenterImpl.View {

  private MainFragPresenterImpl presenter;

  public static MainFragment newInstance(@Nullable Bundle args) {
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public <T extends BasePresenter> void setPresenterToChild(T presenter) {
    this.presenter = (MainFragPresenterImpl) presenter;
  }

  @Override
  public int getLayoutResId() {
    return R.layout.main_frag_default;
  }

}
