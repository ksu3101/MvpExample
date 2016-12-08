package kang.sw.mvpexample.utils.mvp.presenters;

import android.support.annotation.NonNull;

import kang.sw.mvpexample.utils.mvp.view.BaseView;

/**
 * @author robin
 * @since 2016. 12. 2.
 */
public interface BasePresenter<V extends BaseView> {

  void subscribe(@NonNull V view);

  void unSubscribe();

}
