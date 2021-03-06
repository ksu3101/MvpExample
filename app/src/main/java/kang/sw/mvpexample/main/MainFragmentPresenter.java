package kang.sw.mvpexample.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import kang.sw.mvpexample.repository.example.ExampleRepository;
import kang.sw.mvpexample.repository.example.UserInfo;
import kang.sw.mvpexample.repository.example.datasource.ExampleLocalRepository;
import kang.sw.mvpexample.repository.example.datasource.ExampleRemoteRepository;
import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.common.SwObservable;
import kang.sw.mvpexample.utils.mvp.presenters.RxPresenter;
import kang.sw.mvpexample.utils.mvp.view.BaseView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class MainFragmentPresenter
    extends RxPresenter<MainFragmentPresenter.View> {
  private static final String TAG = MainFragmentPresenter.class.getSimpleName();

  public static final String BUNDLE_COUNTER_VALUE = TAG + ".BundleKey_CounterValue";
  public static final int    DEF_VALUE            = 0;

  private View view;
  private int  counterValue;

  @Inject
  public MainFragmentPresenter(@NonNull View viewImplInstance) {
    super(viewImplInstance);
    this.view = viewImplInstance;
  }

  @Override
  public void subscribe(@NonNull View view) {
  }

  public void resetCounterValue() {
    this.counterValue = 0;
    if (view != null) {
      view.updateCounterValue(counterValue);
    }
  }

  public int getCounterValue() {
    return counterValue;
  }

  public void setCounterValue(int counterValue) {
    this.counterValue = counterValue;
    if (view != null) {
      view.updateCounterValue(counterValue);
    }
  }

  public void plusCounterValue() {
    calculateCounterValue(true);
  }

  public void minusCounterValue() {
    calculateCounterValue(false);
  }

  private void calculateCounterValue(final boolean isPlus) {
    final SwObservable observable = new SwObservable(
        this,
        Observable.create(
            new Observable.OnSubscribe<Integer>() {
              @Override
              public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(isPlus ? ++counterValue : --counterValue);
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
              view.updateCounterValue(counterValue);
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
              view.updateCounterValue(value);
            }
            onCompleted();
          }
        }
    );
  }

  private void exampleFunc() {
    final SwObservable observable = new SwObservable(
        this,
        ExampleRepository.getInstance(ExampleLocalRepository.getInstance(), ExampleRemoteRepository.getInstance())
                         .getExamples()
                         .throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                         .subscribeOn(Schedulers.computation())
                         .observeOn(AndroidSchedulers.mainThread())
    );
    observable.subscribe(
        new Subscriber() {
          @Override
          public void onCompleted() {
            // ...
          }

          @Override
          public void onError(Throwable e) {
            // ...
          }

          @Override
          public void onNext(Object o) {
            // ...
          }
        }
    );
  }

  @VisibleForTesting
  public void exampleFunc2(@NonNull final String parseText) {
    final SwObservable observable = new SwObservable(
        this,
        Observable.create(
            new Observable.OnSubscribe<UserInfo>() {
              @Override
              public void call(Subscriber<? super UserInfo> subscriber) {
                Gson gson = new Gson();
                subscriber.onNext(gson.fromJson(parseText, UserInfo.class));
              }
            }
        ).throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.computation())
                  .observeOn(AndroidSchedulers.mainThread())
    );
    observable.subscribe(
        new Subscriber<UserInfo>() {
          @Override
          public void onCompleted() {
          }

          @Override
          public void onError(Throwable e) {
            if (view != null) {
              view.resultOfJsonParsed(null);
            }
          }

          @Override
          public void onNext(UserInfo userInfo) {
            if (view != null) {
              view.resultOfJsonParsed(userInfo);
            }
          }
        }
    );
  }

  public interface View
      extends BaseView {

    void updateCounterValue(int counterValue);

    void resultOfJsonParsed(@Nullable UserInfo userInfo);

  }

}
