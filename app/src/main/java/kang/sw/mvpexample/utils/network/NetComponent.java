package kang.sw.mvpexample.utils.network;

import dagger.Component;
import kang.sw.mvpexample.utils.di.module.AppModule;
import retrofit2.Retrofit;

import javax.inject.Singleton;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
@Singleton
@Component(modules = { AppModule.class, NetModule.class })
public interface NetComponent {

  Retrofit retrofit();

}
