package kang.sw.mvpexample.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import kang.sw.mvpexample.R;
import kang.sw.mvpexample.utils.ActivityUtils;
import kang.sw.mvpexample.utils.common.BaseActivity;

public class MainActivity
    extends BaseActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  @Inject MainFragmentPresenter presenter;

  @Override
  public int getLayoutResId() {
    return R.layout.main_activity;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // initialize binded views (ToolBar, NavDrawer...)

    // get Fragment instance
    MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_frag);
    if (fragment == null) {
      // initialize Bundle instance
      Bundle args = new Bundle();

      // create the fragment
      fragment = MainFragment.newInstance(args);
      ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.main_frag);
    }

    // Create the Fragment Presenter.
    //presenter = new MainFragmentPresenter(fragment);
    DaggerMainFragmentComponent.builder()
                               .mainFragmentPresenterModule(new MainFragmentPresenterModule(fragment))
                               .build()
                               .inject(this);

    // Load previously saved state, if available.
    if (savedInstanceState != null) {
      // read from Bundle
      int value = savedInstanceState.getInt(MainFragmentPresenter.BUNDLE_COUNTER_VALUE, MainFragmentPresenter.DEF_VALUE);
      presenter.setCounterValue(value);
    }
    else {
      presenter.subscribe(fragment);
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // write to Bundle
    outState.putInt(MainFragmentPresenter.BUNDLE_COUNTER_VALUE, presenter.getCounterValue());
    super.onSaveInstanceState(outState);
  }

}
