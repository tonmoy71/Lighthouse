package io.github.tonmoy71.lighthouse.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 28-Sep-17.
 */
@Module public class AppModule {

  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Context provideContext() {
    return application;
  }
}
