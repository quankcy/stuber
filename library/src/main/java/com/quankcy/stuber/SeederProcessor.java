package com.quankcy.stuber;

import com.google.auto.service.AutoService;
import lombok.Getter;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("com.quankcy.stuber.Seeder")
@AutoService(Processor.class)
public class SeederProcessor extends AbstractProcessor {

    private static String FILE_SUFFIX = "Impl";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        roundEnv.getElementsAnnotatedWith(Seeder.class).forEach( element -> {
            Element element1 = element;
            System.out.println("SeederProcessor - process "+Seeder.class.getName()+" annotation - started");

            ClassDescription originalClass = new ClassDescription(element);

            String generatedClassName = originalClass.getClassName() + FILE_SUFFIX;

            System.out.println("SeederProcessor - process "+Seeder.class.getName()+" annotation - stopped");
        });
        return false;
    }

    private class ClassDescription{
        @Getter String packageName;
        @Getter String className;

        public ClassDescription(Element element){
            TypeElement typeElement = (TypeElement) element;
            getPackageAndClassNames(typeElement);
            // Find if implement Seed interface
            // Find Seeding interface definitionsÓ
            // Check fields exists in class used by seed method argument

        }

        private void getPackageAndClassNames(TypeElement element) {
            String qualifiedClassName = element.getQualifiedName().toString();
            int lastDot = qualifiedClassName.lastIndexOf('.');

            if(lastDot > 0) {
                this.packageName = qualifiedClassName.substring(0,lastDot);
            }

            this.className = qualifiedClassName.substring(lastDot + 1);
        }
    }

}
