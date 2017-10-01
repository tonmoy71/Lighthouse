package io.github.tonmoy71.lighthouse.ui.search;

import io.github.tonmoy71.lighthouse.data.DataManager;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchRequest;
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

  private final DataManager dataManager;

  @Inject SearchPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void searchBooks(String query) {
    Map<String, String> params = new HashMap<>();
    params.put("q", query);
    params.put("page", "1");    // TODO: 28-Sep-17 change later

    BookSearchRequest request = new BookSearchRequest();
    request.setOptions(params);

    dataManager.searchBook(request)
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
