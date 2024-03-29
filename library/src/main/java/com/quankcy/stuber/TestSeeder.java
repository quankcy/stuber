package com.quankcy.stuber;

import com.quankcy.stuber.generator.Generator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestSeeder {

    //    String field();
    Class<? extends Generator> value();

}
