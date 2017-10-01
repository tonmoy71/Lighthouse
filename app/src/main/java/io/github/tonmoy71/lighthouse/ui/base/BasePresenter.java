package io.github.tonmoy71.lighthouse.ui.base;

/**
 * Created by tonmoy on 28-Sep-17.
 */

public abstract class BasePresenter<V> {

  private V view;

  public void attachView(V view) {
    this.view = view;
    onViewAttached();
  }

  public void detachView() {
    onViewDetached();
    if (isViewAttached()) {
      view = null;
    }
  }

  public boolean isViewAttached() {
    return getView() != null;
  }

  protected abstract void onViewDetached();

  protected abstract void onViewAttached();

  protected V getView() {
    return view;
  }
}
