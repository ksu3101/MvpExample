package kang.sw.mvpexample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import kang.sw.mvpexample.utils.common.BaseFragment;
import kang.sw.mvpexample.utils.mvp.RxPresenter;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */

public class MainFragment
    extends BaseFragment
    implements MainFragPresenterImpl.View {

  private MainFragPresenterImpl presenter;

  @Nullable
  @Override
  public RxPresenter attachPresenter() {
    this.presenter = new MainFragPresenterImpl(this);
    return presenter;
  }

  @Override
  public int getLayoutResId() {
    return R.layout.main_frag_default;
  }

  public static MainFragment newInstance(@Nullable Bundle args) {
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

}
