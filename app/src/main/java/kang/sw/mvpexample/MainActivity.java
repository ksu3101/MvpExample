package kang.sw.mvpexample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kang.sw.mvpexample.utils.common.BaseActivity;
import kang.sw.mvpexample.utils.mvp.BasePresenter;


public class MainActivity
    extends BaseActivity {

  @Override
  public int getLayoutResId() {
    return R.layout.main_activity;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
