package io.github.tonmoy71.lighthouse.data.network;

/**
 * Created by tonmoy on 27-Sep-17.
 */

public class ApiEndPoint {
  public static final String BASE_URL = "https://www.goodreads.com";
  public static final String REDIRECT_URI = "io.github.tonmoy71.lighthouse://redirect";

  public static final String SEARCH_BOOK = "/search/index.xml";

  public static final String REQUEST_TOKEN_URL = "/oauth/request_token";
  public static final String AUTHORIZE_URL = "/oauth/authorize?mobile=1";
  public static final String ACCESS_TOKEN_URL = "/oauth/access_token";

  public static final String GET_FRIENDS_UPDATES = BASE_URL + "/updates/friends.xml";
  public static final String GET_USER_ID = BASE_URL + "/api/auth_user";

  private ApiEndPoint() {
  }
}
