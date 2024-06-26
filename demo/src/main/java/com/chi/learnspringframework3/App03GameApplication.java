package com.chi.learnspringframework3;

import com.chi.learnspringframework.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

public class App03GameApplication {
    public static void main(String[] args) {

        /* Dependency Injection version */
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            context.getBean(GamingConsole.class).up();

        }

    }
}
