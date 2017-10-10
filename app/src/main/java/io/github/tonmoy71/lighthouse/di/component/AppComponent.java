package io.github.tonmoy71.lighthouse.di.component;

import dagger.Component;
import io.github.tonmoy71.lighthouse.di.module.ApplicationModule;
import io.github.tonmoy71.lighthouse.di.module.NetworkModule;
import io.github.tonmoy71.lighthouse.ui.login.LoginActivity;
import io.github.tonmoy71.lighthouse.ui.search.SearchActivity;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 28-Sep-17.
 */
@Singleton @Component(modules = { ApplicationModule.class, NetworkModule.class })
public interface AppComponent {
  void inject(SearchActivity activity);

  void inject(LoginActivity activity);
}
