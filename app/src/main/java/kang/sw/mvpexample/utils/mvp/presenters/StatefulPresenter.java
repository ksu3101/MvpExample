package kang.sw.mvpexample.utils.mvp.presenters;

import kang.sw.mvpexample.utils.mvp.view.BaseView;

/**
 * @author robin
 * @since 2016. 12. 8.
 */
public abstract class StatefulPresenter<V extends BaseView, S extends BaseState>
  extends RxPresenter<V>
  implements IStatefulPresenter<V, S> {

}
