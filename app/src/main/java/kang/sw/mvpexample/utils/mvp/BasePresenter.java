package kang.sw.mvpexample.utils.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class BasePresenter {
  private CompositeSubscription compositeSubscription;

  public BasePresenter() {
    this.compositeSubscription = new CompositeSubscription();
  }

  @CallSuper
  public Subscription addSubscriber(@NonNull final Subscription subscriber) {
    if (compositeSubscription != null) {
      compositeSubscription.add(subscriber);
    }
    return subscriber;
  }

  @CallSuper
  public void destroy() {
    if (compositeSubscription != null) {
      compositeSubscription.unsubscribe();
    }
  }

}
