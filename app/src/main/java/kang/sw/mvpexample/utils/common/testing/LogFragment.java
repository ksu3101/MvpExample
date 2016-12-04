package kang.sw.mvpexample.utils.common.testing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kang.sw.mvpexample.utils.common.BaseFragment;
import kang.sw.mvpexample.utils.common.SwLog;

/**
 * @author KangSungWoo
 * @since 2016-12-04
 */
public abstract class LogFragment
    extends BaseFragment {
  private static final String TAG = LogFragment.class.getSimpleName();

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    SwLog.d(TAG, "// onAttach() //");
  }

  @NonNull
  protected String loggingOnAttach(Context context) {
    return ("Context is " + (context != null ? "Not Null" : "Null"));
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SwLog.d(TAG, "// onCreate() // " + loggingOnCreate(savedInstanceState));
  }

  @NonNull
  protected String loggingOnCreate(@Nullable Bundle savedInstanceState) {
    return ("savedInstanceState is " + (savedInstanceState != null ? "Not Null" : "Null"));
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    SwLog.d(TAG, "// onCreateView() // " + loggingOnCreateView(savedInstanceState));
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @NonNull
  protected String loggingOnCreateView(@Nullable Bundle savedInstanceState) {
    return ("savedInstanceState is " + (savedInstanceState != null ? "Not Null" : "Null"));
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    SwLog.d(TAG, "// onActivityCreated() // " + loggingOnActivityCreated(savedInstanceState));
  }

  @NonNull
  protected String loggingOnActivityCreated(@Nullable Bundle savedInstanceState) {
    return ("savedInstanceState is " + (savedInstanceState != null ? "Not Null" : "Null"));
  }

  @Override
  public void onStart() {
    super.onStart();
    SwLog.d(TAG, "// onStart() // " + loggingOnStart());
  }

  @NonNull
  protected String loggingOnStart() {
    return "";
  }

  @Override
  public void onResume() {
    super.onResume();
    SwLog.d(TAG, "// onResume() // " + loggingOnResume());
  }

  @NonNull
  protected String loggingOnResume() {
    return "";
  }

  @Override
  public void onPause() {
    super.onPause();
    SwLog.d(TAG, "// onPause() // " + loggingOnPause());
  }

  @NonNull
  protected String loggingOnPause() {
    return "";
  }

  @Override
  public void onStop() {
    super.onStop();
    SwLog.d(TAG, "// onStop() // " + loggingOnStop());
  }

  @NonNull
  protected String loggingOnStop() {
    return "";
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    SwLog.d(TAG, "// onDesrtoyView() // " + loggingOnDestroyView());
  }

  @NonNull
  protected String loggingOnDestroyView() {
    return "";
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    SwLog.d(TAG, "// onDestroy() // " + loggingOnDestroy());
  }

  @NonNull
  protected String loggingOnDestroy() {
    return "";
  }

  @Override
  public void onDetach() {
    super.onDetach();
    SwLog.d(TAG, "// onDetach() // " + loggingOnDetach());
  }

  @NonNull
  protected String loggingOnDetach() {
    return "";
  }

}
