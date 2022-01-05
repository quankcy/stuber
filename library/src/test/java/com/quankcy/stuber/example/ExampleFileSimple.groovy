package com.quankcy.stuber.example

import com.quankcy.stuber.SeedBuilder
import com.quankcy.stuber.generator.RandomGenerator

class ExampleFileSimple {

    @SeedBuilder(RandomGenerator.class)
    String someString;


    Integer someInteger;

}
