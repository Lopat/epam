package com.ddemyanov.javase02.t07;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MyAnno {
    String value() default "Nuclear";
    String type() default "basic";
}
