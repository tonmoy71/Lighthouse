package io.github.tonmoy71.lighthouse.ui.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import io.github.tonmoy71.lighthouse.LighthouseApp;
import io.github.tonmoy71.lighthouse.R;
import io.github.tonmoy71.lighthouse.ui.base.BaseActivity;
import javax.inject.Inject;
import timber.log.Timber;

import static io.github.tonmoy71.lighthouse.data.network.ApiEndPoint.REDIRECT_URI;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

  public static final String KEY_TEMPORARY_REQUEST_TOKEN = "TEMPORARY_REQUEST_TOKEN";
  private static OAuth1RequestToken temporaryRequestToken;
  @Inject LoginPresenter loginPresenter;
  @Inject Context context;
  private Unbinder unbinder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
      temporaryRequestToken =
          (OAuth1RequestToken) savedInstanceState.getSerializable(KEY_TEMPORARY_REQUEST_TOKEN);
    }
  }

  @Override protected void onResume() {
    super.onResume();

    // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
    Uri uri = getIntent().getData();
    if (uri != null && uri.toString().startsWith(REDIRECT_URI)) {
      String code = uri.getQueryParameter("oauth_token");
      String authorize = uri.getQueryParameter("authorize");
      if (authorize != null && authorize.equals("1") && code != null) {
        if (temporaryRequestToken != null) {
          loginPresenter.getAccessToken(temporaryRequestToken);
        }
      } else {
        Toast.makeText(context, "Can't log you in, sorry!", Toast.LENGTH_SHORT).show();
      }
    }
  }

  @Override protected LoginPresenter getPresenter() {
    return loginPresenter;
  }

  @Override protected LoginView getView() {
    return this;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }

  @Override protected void initialize() {
    ((LighthouseApp) getApplication()).getComponent().inject(this);
    unbinder = ButterKnife.bind(this);
  }

  @Override protected void setContentView() {
    setContentView(R.layout.activity_update);
  }

  @Override public void onAuthorizationUrlReceive(String authorizationUrl) {
    if (authorizationUrl != null) {
      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(authorizationUrl));
      startActivity(intent);
    }
  }

  @Override public void onAccessTokenReceive(OAuth1AccessToken accessToken) {
    Timber.d("Finally! Access token -> " + accessToken);

    loginPresenter.getFriendsUpdate(accessToken);
  }

  @Override public void onRequestTokenReceive(OAuth1RequestToken requestToken) {
    if (requestToken != null) {
      temporaryRequestToken = requestToken;
      loginPresenter.authorize(requestToken);
    }
  }

  @Override public void onFriendsUpdateFound(String body) {
    // TODO: 06-Oct-17 Create POJO from xml
  }

  @OnClick(R.id.button_login_with_goodreads) public void onViewClicked() {
    loginPresenter.getRequestToken();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    outState.putSerializable(KEY_TEMPORARY_REQUEST_TOKEN, temporaryRequestToken);

    super.onSaveInstanceState(outState);
  }
}
