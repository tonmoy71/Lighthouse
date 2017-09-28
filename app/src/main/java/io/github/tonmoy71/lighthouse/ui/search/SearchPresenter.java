package io.github.tonmoy71.lighthouse.ui.search;

import io.github.tonmoy71.lighthouse.data.network.SearchApi;
import io.github.tonmoy71.lighthouse.ui.base.BasePresenter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by tonmoy on 28-Sep-17.
 */

public class SearchPresenter extends BasePresenter<SearchView> {

  private final SearchApi searchApi;

  @Inject public SearchPresenter(SearchApi api) {
    searchApi = api;
  }

  public void searchBooks(String query) {
    Map<String, String> params = new HashMap<>();
    params.put("q", query);
    params.put("page", "1");    // TODO: 28-Sep-17 change later
    searchApi.searchBook(params)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(searchResponse -> {
          Timber.d(searchResponse.toString());
          getView().onBookSearch(searchResponse.getSearch().getResults());
        }, Timber::e);
  }

  @Override protected void onViewDetached() {

  }

  @Override protected void onViewAttached() {

  }
}
