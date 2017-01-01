package kang.sw.mvpexample.utils.di.component;

import dagger.Component;
import kang.sw.mvpexample.utils.common.BaseActivity;
import kang.sw.mvpexample.utils.di.module.AppModule;

import javax.inject.Singleton;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {


}
