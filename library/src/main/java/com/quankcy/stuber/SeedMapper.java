package com.quankcy.stuber;

import com.quankcy.stuber.generator.Generator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SeedMapper {

    String source();

    //    String field();
    Class<? extends Generator> generator();

}
