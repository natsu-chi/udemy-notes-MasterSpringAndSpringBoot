package com.chi.learnspringframework3;

import com.chi.learnspringframework.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@ComponentScan("com.chi.learnspringframework")
@Configuration
public class App03GameApplication {

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    public static void main(String[] args) {

        /* Dependency Injection version */
        try (var context = new AnnotationConfigApplicationContext(App03GameApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            context.getBean(GamingConsole.class).up();

        }

    }
}
