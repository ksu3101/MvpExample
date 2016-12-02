package kang.sw.mvpexample;

import android.support.annotation.NonNull;

import kang.sw.mvpexample.utils.mvp.RxPresenter;
import kang.sw.mvpexample.utils.mvp.BaseView;

/**
 * @author KangSungWoo
 * @since 2016-12-01
 */
public class MainFragPresenterImpl
    extends RxPresenter {

  private View view;

  public MainFragPresenterImpl(@NonNull View viewImplInstance) {
    this.view = viewImplInstance;
  }

  @Override
  public void onStart() {
    // TODO : load default datas
  }

  public interface View
      extends BaseView {

  }

}
