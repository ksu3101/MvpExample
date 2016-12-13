package kang.sw.mvpexample.utils.common;

import android.app.Application;

import kang.sw.mvpexample.utils.network.DaggerNetComponent;
import kang.sw.mvpexample.utils.network.NetComponent;
import kang.sw.mvpexample.utils.network.NetModule;

/**
 * @author beemo
 * @since 2016. 12. 13.
 */
public class App extends Application {

  NetComponent netComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    this.netComponent = DaggerNetComponent.builder()
      .appModule(new AppModule(this))
      .netModule(new NetModule("http://baseurl.com"))
      .build();
  }

  public NetComponent getNetComponent() {
    return netComponent;
  }

}
