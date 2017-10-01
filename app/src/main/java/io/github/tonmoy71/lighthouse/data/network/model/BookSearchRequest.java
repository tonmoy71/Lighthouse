package io.github.tonmoy71.lighthouse.data.network.model;

import java.util.Map;

/**
 * Created by tonmoy on 10-Oct-17.
 */

public class BookSearchRequest {
  private Map<String, String> options;

  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }
}
