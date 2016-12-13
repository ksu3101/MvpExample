package kang.sw.mvpexample.utils.common;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
@Module
public class AppModule {

  Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  public Application getApplication() {
    return application;
  }

}
