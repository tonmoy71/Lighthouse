package io.github.tonmoy71.lighthouse.di.component;

import dagger.Component;
import io.github.tonmoy71.lighthouse.di.module.AppModule;
import io.github.tonmoy71.lighthouse.di.module.NetworkModule;
import io.github.tonmoy71.lighthouse.ui.search.SearchActivity;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 28-Sep-17.
 */
@Singleton @Component(modules = { AppModule.class, NetworkModule.class })
public interface AppComponent {
  void inject(SearchActivity activity);
}
