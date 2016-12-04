package kang.sw.mvpexample.utils.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import kang.sw.mvpexample.utils.common.SwLog;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public abstract class RxPresenter
    implements BasePresenter {
  private static final String TAG = RxPresenter.class.getSimpleName();

  private CompositeSubscription compositeSubscription;

  public RxPresenter(@NonNull BaseView viewImpl) {
    this.compositeSubscription = new CompositeSubscription();
    viewImpl.setPresenter(this);
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
