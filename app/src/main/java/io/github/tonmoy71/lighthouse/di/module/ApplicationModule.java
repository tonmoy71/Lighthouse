package io.github.tonmoy71.lighthouse.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.tonmoy71.lighthouse.data.AppDataManager;
import io.github.tonmoy71.lighthouse.data.DataManager;
import io.github.tonmoy71.lighthouse.data.network.ApiHelper;
import io.github.tonmoy71.lighthouse.data.network.AppApiHelper;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 28-Sep-17.
 */
@Module public class ApplicationModule {

  private Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Context provideContext() {
    return application;
  }

  @Provides @Singleton DataManager provideDataManager(AppDataManager appDataManager) {
    return appDataManager;
  }

  @Provides @Singleton ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
    return appApiHelper;
  }
}
