package kang.sw.mvpexample.utils.common;

import dagger.Component;

import javax.inject.Singleton;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

  void inject(BaseActivity activity);

}
