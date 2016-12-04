package kang.sw.mvpexample.utils.common.testing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kang.sw.mvpexample.utils.common.BaseActivity;
import kang.sw.mvpexample.utils.common.SwLog;

/**
 * @author KangSungWoo
 * @since 2016-12-04
 */
public abstract class LogActivity
    extends BaseActivity {
  private static final String TAG = LogActivity.class.getSimpleName();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SwLog.d(TAG, "// onCreate() // " + loggingOnCreate(savedInstanceState));
  }

  @NonNull
  protected String loggingOnCreate(@Nullable Bundle savedInstanceState) {
    return "savedInstanceState is " + (savedInstanceState != null ? "Not Null" : "Null");
  }

  @Override
  protected void onStart() {
    super.onStart();
    SwLog.d(TAG, "// onStart() // " + loggingOnStart());
  }

  @NonNull
  protected String loggingOnStart() {
    return "";
  }

  @Override
  protected void onResume() {
    super.onResume();
    SwLog.d(TAG, "// onResume() // " + loggingOnResume());
  }

  @NonNull
  protected String loggingOnResume() {
    return "";
  }

  @Override
  protected void onPause() {
    super.onPause();
    SwLog.d(TAG, "// onPause() // " + loggingOnPause());
  }

  @NonNull
  protected String loggingOnPause() {
    return "";
  }

  @Override
  protected void onStop() {
    super.onStop();
    SwLog.d(TAG, "// onStop() // " + loggingOnStop());
  }

  @NonNull
  protected String loggingOnStop() {
    return "";
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    SwLog.d(TAG, "// onDestroy() // " + loggingOnDestroy());
  }

  @NonNull
  protected String loggingOnDestroy() {
    return "";
  }

}
