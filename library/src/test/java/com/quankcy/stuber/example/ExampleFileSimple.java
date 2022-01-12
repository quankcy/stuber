package com.quankcy.stuber.example;

import com.quankcy.stuber.TestSeeder;
import com.quankcy.stuber.generator.RandomGenerator;

class ExampleFileSimple {

    @TestSeeder(value = RandomGenerator.class)
    String someString;

}
