package com.quankcy.stuber.example;

import com.quankcy.stuber.GeneratorPair;
import com.quankcy.stuber.generator.Generator;
import com.quankcy.stuber.generator.RandomGenerator;

public class ExampleFile {

    // what access modifier?
    String someString;

    ExampleFile(String someString) {
        this.someString = someString;
    }

    public static ExampleFileSeeder seeder() {
        return new ExampleFileSeeder();
    }

    public static ExampleFile seed(){
        return new ExampleFileSeeder().seed();
    }

    public static class ExampleFileSeeder {
        /* all fields must be private , it is GeneratorPair with defined on field generator*/
//        private GeneratorPair someString = new GeneratorPair(RandomGenerator.class);
//        def constructor = clazz.getConstructor().newInstance()
        private GeneratorPair someString = new GeneratorPair(new RandomGenerator());

        /* package private constructor */
        ExampleFileSeeder() {
//            this.seededWithRulesFile = new SeededWithRulesFile();
        }

        /* double public setter:
            - generator argument
            - same argument as already exists
         */
        public ExampleFileSeeder someString(Generator someStringGenerator) {
            this.someString.setGenerator(someStringGenerator);
            return this;
        }

        public ExampleFileSeeder someString(String someString) {
            this.someString.setValue(someString);
            return this;
        }

        /* seed method */
        public ExampleFile seed() {
            return new ExampleFile(someString.get());
        }

        /*
        public String toString() {
            return "SeederClassTest.SeederClassTestBuilder(someString=" + this.someString + ")";
        }
        */
    }

}
