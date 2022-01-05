package com.quankcy.stuber;

import com.quankcy.stuber.generator.Generator;

import java.util.Optional;

public class GeneratorPair {

    private Generator generator;
    private Optional<String> value;

    public GeneratorPair(Generator generator) {
        this.generator = generator;
        this.value = Optional.empty();
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
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
