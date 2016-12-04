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

  private MainFragPresenterImpl presenter;

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
    this.presenter = new MainFragPresenterImpl(fragment);    // ex

    // Load previously saved state, if available.
    if (savedInstanceState != null) {
      // restore saved state -> view update
      int value = savedInstanceState.getInt(MainFragPresenterImpl.BUNDLE_COUNTER_VALUE, MainFragPresenterImpl.DEF_VALUE);
      Log.i(TAG, "// savedInstanceState is Not Null // saved value = " + value);
      presenter.setCounterValue(value);
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // save fragment Presenter instance state
    final int value = presenter.getCounterValue();
    outState.putInt(MainFragPresenterImpl.BUNDLE_COUNTER_VALUE, value);
    SwLog.w(TAG, "// onSaveInstanceState() // value = " + value);
    super.onSaveInstanceState(outState);
  }


}
