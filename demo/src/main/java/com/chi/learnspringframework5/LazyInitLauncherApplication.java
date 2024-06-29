package com.chi.learnspringframework5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/* Eager / Lazy Initialization */

@Component
class ClassA {

}

@Component
@Lazy
// or @Lazy(value=true)
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(LazyInitLauncherApplication.class)) {

            System.out.println("Initialization of context is completed!");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }

    }
}
