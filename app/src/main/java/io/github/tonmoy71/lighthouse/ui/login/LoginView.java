package io.github.tonmoy71.lighthouse.ui.login;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;

/**
 * Created by tonmoy on 01-Oct-17.
 */

public interface LoginView {
  void onAuthorizationUrlReceive(String authorizationUrl);

  void onAccessTokenReceive(OAuth1AccessToken accessToken);

  void onRequestTokenReceive(OAuth1RequestToken requestToken);

  void onFriendsUpdateFound(String body);
}
