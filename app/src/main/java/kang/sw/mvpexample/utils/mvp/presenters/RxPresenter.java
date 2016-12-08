package kang.sw.mvpexample.utils.mvp.presenters;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import kang.sw.mvpexample.utils.mvp.view.BaseView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public abstract class RxPresenter<V extends BaseView>
    implements BasePresenter<V> {
  private CompositeSubscription compositeSubscription;

  public RxPresenter() {
    this.compositeSubscription = new CompositeSubscription();
  }

  public final Subscription addSubscriber(@NonNull final Subscription subscriber) {
    if (compositeSubscription != null) {
      compositeSubscription.add(subscriber);
    }
    return subscriber;
  }

  @CallSuper
  @Override
  public void unSubscribe() {
    if (compositeSubscription != null) {
      compositeSubscription.unsubscribe();
    }
  }

}
