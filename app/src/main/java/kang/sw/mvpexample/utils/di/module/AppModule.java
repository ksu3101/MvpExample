package kang.sw.mvpexample.utils.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
@Module
public class AppModule {

  private Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  public Context provideContext() {
    return context;
  }

}
