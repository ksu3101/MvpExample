package kang.sw.mvpexample.utils.mvp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public interface BaseView {

  <P extends BasePresenter> void setPresenter(P presenterImpl);

  void onError(@NonNull String tag, @Nullable Object obj);
}
