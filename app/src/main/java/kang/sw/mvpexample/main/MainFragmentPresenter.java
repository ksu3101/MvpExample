package kang.sw.mvpexample.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import kang.sw.mvpexample.repository.example.ExampleRepository;
import kang.sw.mvpexample.repository.example.datasource.ExampleLocalRepository;
import kang.sw.mvpexample.repository.example.datasource.ExampleRemoteRepository;
import kang.sw.mvpexample.utils.common.SwLog;
import kang.sw.mvpexample.utils.common.SwObservable;
import kang.sw.mvpexample.utils.mvp.view.BaseView;
import kang.sw.mvpexample.utils.mvp.presenters.StatefulPresenter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class MainFragmentPresenter
    extends StatefulPresenter<MainFragmentPresenter.View, MainFragmentState> {
  private static final String TAG = MainFragmentPresenter.class.getSimpleName();

  public static final String BUNDLE_COUNTER_VALUE = TAG + ".BundleKey_CounterValue";
  public static final int    DEF_VALUE            = 0;

  private View view;
  private int counterValue;

  public MainFragmentPresenter(@NonNull View viewImplInstance) {
    this.view = viewImplInstance;
    view.setPresenter(this);
  }

  @Override
  public void subscribe(@NonNull View view) {
    this.subscribe(view, null);
  }

  @Override
  public void subscribe(@NonNull View view, @Nullable MainFragmentState state) {
    this.view = view;

    if(state != null) {
      this.counterValue = state.getCounterValue();
    }
    else {
      // set default
      this.counterValue = 0;
    }
    view.updateCounterValue(counterValue);
  }

  @Override
  public MainFragmentState getState() {
    return new MainFragmentState(counterValue);
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

  public interface View
      extends BaseView {

    void updateCounterValue(int counterValue);

  }

}
