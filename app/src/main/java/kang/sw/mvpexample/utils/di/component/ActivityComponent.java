package kang.sw.mvpexample.utils.di.component;

import com.google.gson.annotations.Since;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import kang.sw.mvpexample.utils.common.BaseActivity;
import kang.sw.mvpexample.utils.di.module.ActivityModule;
import kang.sw.mvpexample.utils.di.module.AppModule;

/**
 * @author KangSungWoo
 */
@Singleton
@Component(dependencies = AppModule.class, modules = {ActivityModule.class})
public interface ActivityComponent {

  void inject(BaseActivity activity);

}
