package com.quankcy.stuber.generator;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class GeneratorFactory{
    private static GeneratorFactoryMechanism generatorFactoryMechanism = new GeneratorFactoryMechanism();

    public static <T extends Generator> T getGeneratorInstance(Class<T> generatorClass){
        return (T) generatorFactoryMechanism.getInstance(generatorClass);
    }

    static class GeneratorFactoryMechanism<T extends Generator>{
        private Map<Class<T>, T> instances = new HashMap<>();

        public Generator getInstance(Class<T> generatorClass) {
            return instances.entrySet().stream()
                    .filter(classGeneratorEntry -> classGeneratorEntry.getKey().equals(generatorClass))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElseGet(() -> {
                        T newInstance = getNewInstance(generatorClass);
                        instances.put(generatorClass, newInstance);
                        return newInstance;
                    });
        }

        @SneakyThrows
        private static <T extends Generator> T getNewInstance(Class<T> generatorClass) {
            return generatorClass.getDeclaredConstructor().newInstance();
        }
    }

}
