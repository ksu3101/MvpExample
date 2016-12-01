package kang.sw.mvpexample.utils.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class SwLog {

  public static void d(@NonNull String tag, @Nullable String msg) {
    Log.d(tag, msg != null ? msg : "Message is Null.");
  }

  public static void w(@NonNull String tag, @Nullable String msg) {
    Log.w(tag, msg != null ? msg : "Message is Null.");
  }

  public static void e(@NonNull String tag, @Nullable String msg) {
    Log.e(tag, msg != null ? msg : "Message is Null.");
  }

}
