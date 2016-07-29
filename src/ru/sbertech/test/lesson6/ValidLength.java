package ru.sbertech.test.lesson6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLength {
    int value() default 4;
}
