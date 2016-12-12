package kang.sw.mvpexample.main;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Dependence Inject(DI)에 필요한 인스턴스를 제공(Provide)하는 Dagger의 Module 클래스.
 *
 * @author KangSung-Woo
 * @since 2016-12-12
 */
@Module
public class MainFragmentPresenterModule {

  private final MainFragmentPresenter.View view;

  public MainFragmentPresenterModule(MainFragmentPresenter.View view) {
    this.view = view;
  }

  @Provides
  MainFragmentPresenter.View provideMainFragmentView() {
    return this.view;
  }

}
