package io.github.tonmoy71.lighthouse.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tonmoy on 28-Sep-17.
 */

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView();
    initialize();
    getPresenter().attachView(getView());
  }

  protected abstract P getPresenter();

  protected abstract V getView();

  protected abstract void initialize();

  protected abstract void setContentView();
}
