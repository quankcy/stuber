package com.quankcy.stuber

import com.quankcy.stuber.example.ExampleFile
import spock.lang.Specification

class SeederAnnotationUT extends Specification{

    def "Check if Seeder Annotation loader works"(){
        def definedPackage = ClassLoader.getSystemClassLoader().getDefinedPackage()
        expect:
//            def packageDir = new ClassLoaderPicker().getPackageRelativeDirectory()
//            def resourcesStream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageDir)
            def resourcesStream = definedPackage
//        SeederClassTest.builder()
//            resourcesStream.find()
    }

    def "Usage"(){
        expect:
            def seed1 = ExampleFile.seeder().someString("new value").seed()

            def seed2 = ExampleFile.seeder().seed()

            def seed3 = ExampleFile.seed()

            true
    }
}
