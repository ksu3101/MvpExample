package kang.sw.mvpexample.utils.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author KangSungWoo
 */
@Module
public class ActivityModule {

  private Context context;

  public ActivityModule(Context context) {
    this.context = context;
  }

  @Provides
  public Context provideContext() {
    return context;
  }

}
