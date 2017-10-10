package io.github.tonmoy71.lighthouse.di.module;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import dagger.Module;
import dagger.Provides;
import io.github.tonmoy71.lighthouse.BuildConfig;
import io.github.tonmoy71.lighthouse.data.network.ApiEndPoint;
import io.github.tonmoy71.lighthouse.data.network.GoodreadsApi;
import io.github.tonmoy71.lighthouse.data.network.service.SearchService;
import io.github.tonmoy71.lighthouse.di.RequiresApiKey;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by tonmoy on 27-Sep-17.
 */
@Module public class NetworkModule {
  @Provides @Singleton HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }

  @Provides @Singleton Interceptor provideRequestInterceptor() {
    return chain -> {
      Request original = chain.request();
      HttpUrl originalHttpUrl = original.url();
      HttpUrl url = originalHttpUrl.newBuilder()
          .addQueryParameter("key", BuildConfig.GOODREADS_API_KEY)
          .build();
      // Request customization: add request headers
      Request.Builder requestBuilder = original.newBuilder().url(url);
      Request request = requestBuilder.build();
      return chain.proceed(request);
    };
  }

  @Provides @Singleton @RequiresApiKey OkHttpClient provideOkHttpClientApi(
      HttpLoggingInterceptor loggingInterceptor, Interceptor requestInterceptor) {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(loggingInterceptor);
    httpClient.addInterceptor(requestInterceptor);
    return httpClient.build();
  }

  @Provides @Singleton OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(loggingInterceptor);
    return httpClient.build();
  }

  @Provides @Singleton @RequiresApiKey Retrofit provideRetrofitWithApi(
      @RequiresApiKey OkHttpClient httpClient) {
    return new Retrofit.Builder().baseUrl(ApiEndPoint.BASE_URL)
        .addConverterFactory(
            SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(httpClient)
        .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(OkHttpClient httpClient) {
    return new Retrofit.Builder().baseUrl(ApiEndPoint.BASE_URL)
        .addConverterFactory(
            SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(httpClient)
        .build();
  }

  @Provides @Singleton SearchService provideSearchService(@RequiresApiKey Retrofit retrofit) {
    return retrofit.create(SearchService.class);
  }

  @Provides @Singleton OAuth10aService provideGoodreadsOAuthService() {
    return new ServiceBuilder().apiKey(BuildConfig.GOODREADS_API_KEY)
        .apiSecret(BuildConfig.GOODREADS_API_SECRET)
        .callback(ApiEndPoint.REDIRECT_URI)
        .debug()
        .build(GoodreadsApi.instance());
  }
}
