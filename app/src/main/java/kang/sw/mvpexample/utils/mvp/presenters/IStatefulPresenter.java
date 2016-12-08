package kang.sw.mvpexample.utils.mvp.presenters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kang.sw.mvpexample.utils.mvp.view.BaseView;

/**
 * @author robin
 * @since 2016. 12. 8.
 */
public interface IStatefulPresenter<V extends BaseView, S extends BaseState> extends BasePresenter<V> {

  void subscribe(@NonNull V view, @Nullable S state);

  S getState();

}
