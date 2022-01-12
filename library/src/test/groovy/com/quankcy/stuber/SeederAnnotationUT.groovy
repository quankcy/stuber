package com.quankcy.stuber

import com.quankcy.stuber.example.ExampleFile
import com.quankcy.stuber.generator.GeneratorFactory
import com.quankcy.stuber.generator.RandomGenerator
import org.objectweb.asm.ClassReader
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import spock.lang.Specification

class SeederAnnotationUT extends Specification{

    def "Check if Seeder Annotation loader works"(){
        expect:
//            def definedPackage = ClassLoader.getSystemClassLoader().getDefinedPackage()
//            def packageDir = new ClassLoaderPicker().getPackageRelativeDirectory()
//            def resourcesStream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageDir)
//            def resourcesStream = definedPackage
//        SeederClassTest.builder()
//            resourcesStream.find()
            ClassNode classNode = new ClassNode(Opcodes.ASM9);
//            ClassPrinter classPrinter = new ClassPrinter();
//            ClassReader classReader = new ClassReader("java.lang.Runnable");
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFileSimple");
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFile");
            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFile\$ExampleFileSeeder");
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFileSeeder");
            classReader.accept(classNode, 0);
//            classReader.accept(classPrinter, 0);

        true
    }

    def "Usage"(){
        expect:
            def clazz = RandomGenerator.class

            def seeder = ExampleFile.seeder()

            def seed1 = ExampleFile.seeder().someString("new value").seed()
            def seed2 = ExampleFile.seeder().someString(RandomGenerator.class).seed()

            def seed3a = seeder.seed()
            def seed3b = seeder.seed()

            seed3a != seed3b

            def seed4 = ExampleFile.seed()

            true
    }

    def "Generator Factory"(){
        expect:
            def instance1 = GeneratorFactory.getGeneratorInstance(RandomGenerator.class)
            def instance2 = GeneratorFactory.getGeneratorInstance(RandomGenerator.class)
            instance1 == instance2
    }
}
