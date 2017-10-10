package io.github.tonmoy71.lighthouse.data.network;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

import static io.github.tonmoy71.lighthouse.data.network.ApiEndPoint.ACCESS_TOKEN_URL;
import static io.github.tonmoy71.lighthouse.data.network.ApiEndPoint.AUTHORIZE_URL;
import static io.github.tonmoy71.lighthouse.data.network.ApiEndPoint.BASE_URL;
import static io.github.tonmoy71.lighthouse.data.network.ApiEndPoint.REQUEST_TOKEN_URL;

/**
 * Created by tonmoy on 01-Oct-17.
 */

public class GoodreadsApi extends DefaultApi10a {
  private GoodreadsApi() {
  }

  public static GoodreadsApi instance() {
    return InstanceHolder.instance;
  }

  @Override public String getRequestTokenEndpoint() {
    return new StringBuilder().append(BASE_URL).append(REQUEST_TOKEN_URL).toString();
  }

  @Override public String getAccessTokenEndpoint() {
    return new StringBuilder().append(BASE_URL).append(ACCESS_TOKEN_URL).toString();
  }

  @Override public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
    return new StringBuilder().append(BASE_URL)
        .append(AUTHORIZE_URL)
        .append("&oauth_token=")
        .append(requestToken.getToken())
        .toString();
  }

  private static class InstanceHolder {
    private static final GoodreadsApi instance = new GoodreadsApi();
  }
}
