package com.quankcy.stuber

import com.quankcy.stuber.ast.BytecodeGenerator
import com.quankcy.stuber.example.onlystring.OnlyString
import com.quankcy.stuber.generator.GeneratorFactory
import com.quankcy.stuber.generator.RandomGenerator
import org.objectweb.asm.ClassReader
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import spock.lang.Specification

class SeederAnnotationUT extends Specification{

    def "Check if Seeder Annotation loader works"(){
        expect:
            new BytecodeGenerator().generate(OnlyString.class)
            true
    }

    def "Usage"(){
        expect:
            def clazz = RandomGenerator.class

            def seeder = OnlyString.seeder()

            def seed1 = OnlyString.seeder().someString("new value").seed()
            def seed2 = OnlyString.seeder().someString(RandomGenerator.class).seed()
            
            def seed3a = seeder.seed()
            def seed3b = seeder.seed()

            seed3a != seed3b

            def seed4 = OnlyString.seed()

            true
    }

    def "Generator Factory"(){
        expect:
            def instance1 = GeneratorFactory.getGeneratorInstance(RandomGenerator.class)
            def instance2 = GeneratorFactory.getGeneratorInstance(RandomGenerator.class)
            instance1 == instance2
    }
}
