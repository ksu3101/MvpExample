package kang.sw.mvpexample.main;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.common.SwObservable;
import kang.sw.mvpexample.utils.mvp.BaseView;
import kang.sw.mvpexample.utils.mvp.RxPresenter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class MainFragPresenterImpl
    extends RxPresenter {
  private static final String TAG = MainFragPresenterImpl.class.getSimpleName();

  public static final String BUNDLE_VALUE = TAG + ".BundleKey_Value";
  public static final int    DEF_VALUE    = 0;

  private View view;
  private int  value;

  public MainFragPresenterImpl(@NonNull View viewImplInstance) {
    super(viewImplInstance);
    this.view = viewImplInstance;
  }

  @Override
  public void onStart() {
    view.updateValue(value);
  }

  public void resetValue() {
    this.value = 0;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
    if (view != null) {
      view.updateValue(value);
    }
  }

  public void plusValue() {
    calculateValue(true);
  }

  public void minusValue() {
    calculateValue(false);
  }

  private void calculateValue(final boolean isPlus) {
    final SwObservable observable = new SwObservable(
        this,
        Observable.create(
            new Observable.OnSubscribe<Integer>() {
              @Override
              public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(isPlus ? ++value : --value);
              }
            }
        ).throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                  .delay(700, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.computation())
                  .observeOn(AndroidSchedulers.mainThread())
    );
    observable.subscribe(
        new Subscriber<Integer>() {
          @Override
          public void onCompleted() {
            SwLog.w(TAG, "SwObservable // onCompleted()");
            if (view != null) {
              view.updateValue(value);
            }
          }

          @Override
          public void onError(Throwable e) {
            SwLog.e(TAG, "SwObservable // onError()");
            if (view != null) {
              view.onError(TAG, e);
            }
          }

          @Override
          public void onNext(Integer value) {
            SwLog.w(TAG, "SwObservable // onNext()");
            if (view != null) {
              view.updateValue(value);
            }
            onCompleted();
          }
        }
    );
  }

  public interface View
      extends BaseView {

    void updateValue(int value);

  }

}
