package com.quankcy.stuber;

import com.quankcy.stuber.generator.Generator;

import java.util.Optional;

import static com.quankcy.stuber.generator.GeneratorFactory.getGeneratorInstance;

public class GeneratorPair {

    private Generator generator;
    private Optional<String> value;

    public <T extends Generator> GeneratorPair(Class<T> generatorClass) {
        this.setGenerator(generatorClass);
        this.value = Optional.empty();
    }

    public <T extends Generator> void setGenerator(Class<T> generatorClass) {
        this.generator = getGeneratorInstance(generatorClass);
    }

    public void setValue(String value) {
        this.value = Optional.of(value);
    }

    public Generator getGenerator() {
        return generator;
    }

    public Optional<String> getValue() {
        return value;
    }

    public String get() {
        return value.orElseGet(() -> generator.generate());
    }
}
