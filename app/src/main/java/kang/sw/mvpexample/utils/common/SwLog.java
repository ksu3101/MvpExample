package kang.sw.mvpexample.utils.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class SwLog {
  private static final int LOG_DEF_LENGTH = 1000;

  public static void v(@NonNull String tag, @Nullable String msg) {
    if (msg != null) {
      for (int i = 0; i <= msg.length() / LOG_DEF_LENGTH; i++) {
        int start = i * LOG_DEF_LENGTH;
        int end = (i + 1) * LOG_DEF_LENGTH;
        end = (end > msg.length() ? msg.length() : end);
        Log.v(tag + "[" + i + "] ", msg.substring(start, end));
      }
    }
    else {
      Log.v(tag, "Message is Null.");
    }
  }

  public static void i(@NonNull String tag, @Nullable String msg) {
    if (msg != null) {
      for (int i = 0; i <= msg.length() / LOG_DEF_LENGTH; i++) {
        int start = i * LOG_DEF_LENGTH;
        int end = (i + 1) * LOG_DEF_LENGTH;
        end = (end > msg.length() ? msg.length() : end);
        Log.i(tag + "[" + i + "] ", msg.substring(start, end));
      }
    }
    else {
      Log.i(tag, "Message is Null.");
    }
  }

  public static void d(@NonNull String tag, @Nullable String msg) {
    if (msg != null) {
      for (int i = 0; i <= msg.length() / LOG_DEF_LENGTH; i++) {
        int start = i * LOG_DEF_LENGTH;
        int end = (i + 1) * LOG_DEF_LENGTH;
        end = (end > msg.length() ? msg.length() : end);
        Log.d(tag + "[" + i + "] ", msg.substring(start, end));
      }
    }
    else {
      Log.d(tag, "Message is Null.");
    }
  }

  public static void w(@NonNull String tag, @Nullable String msg) {
    if (msg != null) {
      for (int i = 0; i <= msg.length() / LOG_DEF_LENGTH; i++) {
        int start = i * LOG_DEF_LENGTH;
        int end = (i + 1) * LOG_DEF_LENGTH;
        end = (end > msg.length() ? msg.length() : end);
        Log.w(tag + "[" + i + "] ", msg.substring(start, end));
      }
    }
    else {
      Log.w(tag, "Message is Null.");
    }
  }

  public static void e(@NonNull String tag, @Nullable String msg) {
    if (msg != null) {
      for (int i = 0; i <= msg.length() / LOG_DEF_LENGTH; i++) {
        int start = i * LOG_DEF_LENGTH;
        int end = (i + 1) * LOG_DEF_LENGTH;
        end = (end > msg.length() ? msg.length() : end);
        Log.e(tag + "[" + i + "] ", msg.substring(start, end));
      }
    }
    else {
      Log.e(tag, "Message is Null.");
    }
  }

}
