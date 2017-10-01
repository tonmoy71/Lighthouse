package io.github.tonmoy71.lighthouse.data.network;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.Response;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchRequest;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import rx.Observable;

/**
 * Created by tonmoy on 10-Oct-17.
 */

public interface ApiHelper {
  Observable<OAuth1RequestToken> getRequestToken();

  Observable<String> getAuthorizationUrl(OAuth1RequestToken requestToken);

  Observable<OAuth1AccessToken> getAccessToken(OAuth1RequestToken requestToken);

  Observable<Response> getFriendsUpdate(OAuth1AccessToken accessToken);

  Observable<BookSearchResponse> searchBook(BookSearchRequest request);
}
