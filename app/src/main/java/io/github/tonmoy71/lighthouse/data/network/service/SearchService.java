package io.github.tonmoy71.lighthouse.data.network.service;

import io.github.tonmoy71.lighthouse.data.network.ApiEndPoint;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by tonmoy on 27-Sep-17.
 */

public interface SearchService {
  @GET(ApiEndPoint.SEARCH_BOOK) Observable<BookSearchResponse> searchBook(
      @QueryMap Map<String, String> options);
}
