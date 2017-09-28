package io.github.tonmoy71.lighthouse;

import android.app.Application;
import io.github.tonmoy71.lighthouse.di.component.AppComponent;
import io.github.tonmoy71.lighthouse.di.component.DaggerAppComponent;
import io.github.tonmoy71.lighthouse.di.module.AppModule;
import io.github.tonmoy71.lighthouse.di.module.NetworkModule;
import timber.log.Timber;

/**
 * Created by tonmoy on 19-Sep-17.
 */

public class LighthouseApp extends Application {
  private AppComponent component;

  public AppComponent getComponent() {
    return component;
  }

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    component = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .networkModule(new NetworkModule())
        .build();
  }
}
