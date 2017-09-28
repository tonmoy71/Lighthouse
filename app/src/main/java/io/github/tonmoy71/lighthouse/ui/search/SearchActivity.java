package io.github.tonmoy71.lighthouse.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import io.github.tonmoy71.lighthouse.LighthouseApp;
import io.github.tonmoy71.lighthouse.R;
import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import io.github.tonmoy71.lighthouse.ui.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

public class SearchActivity extends BaseActivity<SearchView, SearchPresenter>
    implements SearchView {

  @Inject SearchPresenter searchPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected SearchPresenter getPresenter() {
    return searchPresenter;
  }

  @Override protected SearchView getView() {
    return this;
  }

  @Override protected void initialize() {
    ((LighthouseApp) getApplication()).getComponent().inject(this);
    searchPresenter.searchBooks("Game of thrones");
  }

  @Override protected void setContentView() {
    setContentView(R.layout.activity_search);
  }

  @Override public void onBookSearch(List<BookSearchResponse.Work> results) {

  }
}
