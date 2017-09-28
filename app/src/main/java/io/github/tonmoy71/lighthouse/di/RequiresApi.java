package io.github.tonmoy71.lighthouse.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * Created by tonmoy on 27-Sep-17.
 */

@Qualifier @Retention(RetentionPolicy.RUNTIME) public @interface RequiresApi {
}
