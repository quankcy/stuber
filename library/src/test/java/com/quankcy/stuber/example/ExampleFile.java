package com.quankcy.stuber.example;

import com.quankcy.stuber.GeneratorPair;
import com.quankcy.stuber.generator.Generator;
import com.quankcy.stuber.generator.RandomGenerator;

// Stubbed
public class ExampleFile {

    String someString;
//    Integer someInteger;

    ExampleFile(String someString) {
//    SeededWithRulesFile(String someString, Integer someInteger) {
        this.someString = someString;
//        this.someInteger = someInteger;
    }

    public static ExampleFileSeeder seeder() {
        return new ExampleFileSeeder();
    }

    public static ExampleFile seed(){
        return new ExampleFileSeeder().seed();
    }

    public static class ExampleFileSeeder {
        //        private SeededWithRulesFile seededWithRulesFile;
        private GeneratorPair someString = new GeneratorPair(new RandomGenerator());
//        private GeneratorPair<Integer> someInteger;

        ExampleFileSeeder() {
//            this.seededWithRulesFile = new SeededWithRulesFile();
        }

        public ExampleFileSeeder someString(Generator someStringGenerator) {
            this.someString.setGenerator(someStringGenerator);
            return this;
        }

        public ExampleFileSeeder someString(String someString) {
            this.someString.setValue(someString);
            return this;
        }

//        public SeededWithRulesFileSeeder someInteger(Integer someInteger) {
//            this.someInteger = someInteger;
//            return this;
//        }

        public ExampleFile seed() {
            return new ExampleFile(someString.get());
        }

        public String toString() {
            return "SeederClassTest.SeederClassTestBuilder(someString=" + this.someString + ")";
        }

    }

}
