package annotations.Ex1;

import examples.annotations.database.Constraints;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLReal {
  String name() default "";

  Constraints constraints() default @Constraints;
}
