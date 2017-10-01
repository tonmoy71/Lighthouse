package io.github.tonmoy71.lighthouse.data;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.Response;
import io.github.tonmoy71.lighthouse.data.network.ApiHelper;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchRequest;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by tonmoy on 10-Oct-17.
 */

@Singleton public class AppDataManager implements DataManager {

  private final ApiHelper apiHelper;

  @Inject public AppDataManager(ApiHelper apiHelper) {
    this.apiHelper = apiHelper;
  }

  @Override public Observable<OAuth1RequestToken> getRequestToken() {
    return apiHelper.getRequestToken();
  }

  @Override public Observable<String> getAuthorizationUrl(OAuth1RequestToken requestToken) {
    return apiHelper.getAuthorizationUrl(requestToken);
  }

  @Override public Observable<OAuth1AccessToken> getAccessToken(OAuth1RequestToken requestToken) {
    return apiHelper.getAccessToken(requestToken);
  }

  @Override public Observable<Response> getFriendsUpdate(OAuth1AccessToken accessToken) {
    return apiHelper.getFriendsUpdate(accessToken);
  }

  @Override public Observable<BookSearchResponse> searchBook(BookSearchRequest request) {
    return apiHelper.searchBook(request);
  }
}
