package com.quankcy.stuber.ast;

import lombok.SneakyThrows;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class BytecodeGenerator {

    @SneakyThrows
    public void generate(Class clazz){
        String className = clazz.getName();
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
//            ClassReader classReader = new ClassReader("com/quankcy/stuber/example/ExampleFile");
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.onlystring.OnlyString");
        ClassReader classReader = new ClassReader(className);
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFile\$ExampleFileSeeder");
//            ClassReader classReader = new ClassReader("com.quankcy.stuber.example.ExampleFileSeeder");
        classReader.accept(classNode, 0);
//            classReader.accept(classPrinter, 0);

        List<FieldNode> fields = classNode.fields;
        List<MethodNode> methods = classNode.methods;
//        classReader.properties
    }
}
