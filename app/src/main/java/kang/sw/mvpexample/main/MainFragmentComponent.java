package kang.sw.mvpexample.main;

import dagger.Component;
import kang.sw.mvpexample.utils.common.FragmentScope;

/**
 * @author KangSung-Woo
 * @since 2016-12-12
 */
@FragmentScope
@Component(modules = MainFragmentPresenterModule.class)
public interface MainFragmentComponent {

  void inject(MainActivity activity);

}
