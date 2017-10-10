package io.github.tonmoy71.lighthouse.data.network;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchRequest;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import io.github.tonmoy71.lighthouse.data.network.service.SearchService;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import timber.log.Timber;

/**
 * Created by tonmoy on 10-Oct-17.
 */

@Singleton public class AppApiHelper implements ApiHelper {

  private final SearchService searchService;
  private final OAuth10aService oAuthService;

  @Inject public AppApiHelper(SearchService searchService, OAuth10aService oAuth10aService) {
    this.searchService = searchService;
    oAuthService = oAuth10aService;
  }

  @Override public Observable<OAuth1RequestToken> getRequestToken() {
    return Observable.fromCallable(() -> {
      OAuth1RequestToken requestToken = oAuthService.getRequestToken();
      Timber.d("Request token -> " + requestToken);
      return requestToken;
    });
  }

  @Override public Observable<String> getAuthorizationUrl(OAuth1RequestToken requestToken) {
    return Observable.fromCallable(() -> {
      String authorizationUrl = oAuthService.getAuthorizationUrl(requestToken);
      Timber.d("Authorization URL -> " + authorizationUrl);
      return authorizationUrl;
    });
  }

  @Override public Observable<OAuth1AccessToken> getAccessToken(OAuth1RequestToken requestToken) {
    return Observable.fromCallable(() -> {
      String oauthVerifier = "";
      OAuth1AccessToken accessToken = oAuthService.getAccessToken(requestToken, oauthVerifier);
      Timber.d("Access token -> " + accessToken.getRawResponse());
      return accessToken;
    });
  }

  @Override public Observable<Response> getFriendsUpdate(OAuth1AccessToken accessToken) {
    return Observable.fromCallable(() -> {
      OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, ApiEndPoint.GET_FRIENDS_UPDATES);
      oAuthService.signRequest(accessToken, oAuthRequest);
      Response response = oAuthService.execute(oAuthRequest);
      Timber.d(response.getBody());
      return response;
    });
  }

  @Override public Observable<BookSearchResponse> searchBook(BookSearchRequest request) {
    return searchService.searchBook(request.getOptions());
  }
}
