package io.github.tonmoy71.lighthouse.ui.login;

import android.support.annotation.NonNull;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import io.github.tonmoy71.lighthouse.data.DataManager;
import io.github.tonmoy71.lighthouse.ui.base.BasePresenter;
import java.io.IOException;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by tonmoy on 01-Oct-17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

  private final DataManager dataManager;

  @Inject LoginPresenter(DataManager dataManager) {

    this.dataManager = dataManager;
  }

  void getRequestToken() {
    dataManager.getRequestToken()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(requestToken -> getView().onRequestTokenReceive(requestToken), Timber::e);
  }

  @Override protected void onViewDetached() {

  }

  @Override protected void onViewAttached() {

  }

  void getAccessToken(@NonNull OAuth1RequestToken temporaryRequestToken) {
    dataManager.getAccessToken(temporaryRequestToken)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(accessToken -> getView().onAccessTokenReceive(accessToken), Timber::e);
  }

  void authorize(@NonNull OAuth1RequestToken requestToken) {
    dataManager.getAuthorizationUrl(requestToken)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(authorizationUrl -> getView().onAuthorizationUrlReceive(authorizationUrl),
            Timber::e);
  }

  void getFriendsUpdate(OAuth1AccessToken accessToken) {
    dataManager.getFriendsUpdate(accessToken)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(response -> {
          if (response.isSuccessful()) {
            try {
              getView().onFriendsUpdateFound(response.getBody());
            } catch (IOException e) {
              Timber.e(e);
            }
          }
        }, Timber::e);
  }
}
