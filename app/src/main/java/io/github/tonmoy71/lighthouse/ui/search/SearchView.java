package io.github.tonmoy71.lighthouse.ui.search;

import io.github.tonmoy71.lighthouse.data.network.model.BookSearchResponse;
import java.util.List;

/**
 * Created by tonmoy on 28-Sep-17.
 */

interface SearchView {
  void onBookSearch(List<BookSearchResponse.Work> results);
}
