package kang.sw.mvpexample.utils.mvp.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kang.sw.mvpexample.utils.mvp.presenters.BasePresenter;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public interface BaseView {

  void setPresenter(@NonNull BasePresenter presenter);

  void onError(@NonNull String tag, @Nullable Object obj);

}
