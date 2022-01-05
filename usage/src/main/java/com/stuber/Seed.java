package com.stuber;

@FunctionalInterface
public interface Seed<T> {

    T seed(T t);

}
