package kang.sw.mvpexample;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.os.Bundle;

import kang.sw.mvpexample.utils.common.BaseActivity;

public class MainActivity
    extends BaseActivity {

  private MainFragPresenterImpl presenter;

  @Override
  public int getLayoutResId() {
    return R.layout.main_activity;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // initialize binded views (ToolBar, NavDrawer...)

    // TODO : get Fragment instance
    MainFragment fragment = MainFragment.newInstance(null);	// ex

    // TODO : Create the Fragment Presenter with Saved instance state.
    //presenter = new MainFragPresenterImpl(savedInstanceState, fragment);
	  presenter = new MainFragPresenterImpl(fragment);		// ex

    // TODO : Load previously saved state, if available.
    if(savedInstanceState != null) {
      // restore saved state -> view update
      //presenter.setData();
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // TODO : save fragment Presenter instance state
    super.onSaveInstanceState(outState);
  }


}
