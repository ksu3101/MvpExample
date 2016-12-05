package kang.sw.mvpexample.utils.common;

/**
 * @author robin
 * @since 2016. 12. 5.
 */
public interface OnSoftKeyboardVisibility {
  void onSoftKeyboardShown(int keyboardHeight);

  void onSoftKeyboardHide();
}
