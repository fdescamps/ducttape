package ducttape.managers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderSent {
}
