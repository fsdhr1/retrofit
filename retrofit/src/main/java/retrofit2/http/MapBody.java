package retrofit2.http;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Nullable;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName MapBody
 * @Description TODO
 * @Author: fs
 * @Date: 2023/1/29 16:58
 * @Version 2.0
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface MapBody {
  String value();

  String defaultValue() default "";
}
