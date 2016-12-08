package kang.sw.mvpexample.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import kang.sw.mvpexample.R;
import kang.sw.mvpexample.utils.ActivityUtils;
import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.common.testing.LogActivity;

public class MainActivity
    extends LogActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  private MainFragmentPresenter presenter;

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

    // Create the Fragment Presenter with Saved instance state.
    presenter = new MainFragmentPresenter(fragment);    // ex

    // Load previously saved state, if available.
    if (savedInstanceState != null) {
      // read from Bundle
      int value = savedInstanceState.getInt(MainFragmentPresenter.BUNDLE_COUNTER_VALUE, MainFragmentPresenter.DEF_VALUE);
      presenter.subscribe(fragment, new MainFragmentState(value));
    }
    else {
      presenter.subscribe(fragment);
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // write to Bundle
    final int value = presenter.getCounterValue();
    outState.putInt(MainFragmentPresenter.BUNDLE_COUNTER_VALUE, presenter.getState().getCounterValue());
    super.onSaveInstanceState(outState);
  }

}
