package src;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(value = ParamsContainer.class)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Params {
    String[] params();
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface ParamsContainer {
    Params[] value();
}