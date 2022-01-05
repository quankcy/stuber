package com.quankcy.stuber;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class Seeders {

    private static final String IMPLEMENTATION_SUFFIX = "Impl";

    private Seeders(){}

    public static <T> T getSeeder(Class<T> clazz) {
        try {
            List<ClassLoader> classLoaders = collectClassLoaders( clazz.getClassLoader() );

            return getSeeder( clazz, classLoaders );
        }
        catch ( ClassNotFoundException | NoSuchMethodException e ) {
            throw new RuntimeException( e );
        }
    }

    private static <T> T getSeeder(Class<T> mapperType, Iterable<ClassLoader> classLoaders)
            throws ClassNotFoundException, NoSuchMethodException {

        for ( ClassLoader classLoader : classLoaders ) {
            T mapper = doGetSeeder( mapperType, classLoader );
            if ( mapper != null ) {
                return mapper;
            }
        }

        throw new ClassNotFoundException("Cannot find implementation for " + mapperType.getName() );
    }

    private static <T> T doGetSeeder(Class<T> clazz, ClassLoader classLoader) throws NoSuchMethodException {
        try {
            @SuppressWarnings( "unchecked" )
            Class<T> implementation = (Class<T>) classLoader.loadClass( clazz.getName() + IMPLEMENTATION_SUFFIX );
            Constructor<T> constructor = implementation.getDeclaredConstructor();
            constructor.setAccessible( true );

            return constructor.newInstance();
        }
        catch (ClassNotFoundException e) {
            return getSeederFromServiceLoader( clazz, classLoader );
        }
        catch ( InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException( e );
        }
    }

    private static <T> T getSeederFromServiceLoader(Class<T> clazz, ClassLoader classLoader) {
        ServiceLoader<T> loader = ServiceLoader.load( clazz, classLoader );

        for ( T mapper : loader ) {
            if ( mapper != null ) {
                return mapper;
            }
        }

        return null;
    }

    private static List<ClassLoader> collectClassLoaders(ClassLoader classLoader) {
        List<ClassLoader> classLoaders = new ArrayList<>( 3 );
        classLoaders.add( classLoader );

        if ( Thread.currentThread().getContextClassLoader() != null ) {
            classLoaders.add( Thread.currentThread().getContextClassLoader() );
        }

        classLoaders.add( Seeders.class.getClassLoader() );

        return classLoaders;
    }

}
