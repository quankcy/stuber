package com.quankcy.stuber.example.onlystring.output;

import com.quankcy.stuber.GeneratorPair;
import com.quankcy.stuber.generator.Generator;
import com.quankcy.stuber.generator.RandomGenerator;

public class OnlyString {

    // what access modifier? should stay this same
    String someString;

    // all args constructor
    OnlyString(String someString) {
        this.someString = someString;
    }

    public static OnlyStringSeeder seeder() {
        return new OnlyStringSeeder();
    }

    public static OnlyString seed() {
        return new OnlyStringSeeder().seed();
    }

    public static class OnlyStringSeeder<T extends Generator> {
        /* all fields must be private , it is GeneratorPair with defined on field generator*/
//        private GeneratorPair someString = new GeneratorPair(RandomGenerator.class);
//        def constructor = clazz.getConstructor().newInstance()
        private GeneratorPair someString = new GeneratorPair(RandomGenerator.class);

        /* package private constructor */
        OnlyStringSeeder() {
//            this.seededWithRulesFile = new SeededWithRulesFile();
        }

        /* double public setter:
            - generator argument
            - same argument as already exists
         */
        public OnlyStringSeeder someString(Class<T> someStringGenerator) {
            this.someString.setGenerator(someStringGenerator);
            return this;
        }

        public OnlyStringSeeder someString(String someString) {
            this.someString.setValue(someString);
            return this;
        }

        /* seed method */
        public OnlyString seed() {
            return new OnlyString(someString.get());
        }

        /*
        public String toString() {
            return "SeederClassTest.SeederClassTestBuilder(someString=" + this.someString + ")";
        }
        */
    }

}
