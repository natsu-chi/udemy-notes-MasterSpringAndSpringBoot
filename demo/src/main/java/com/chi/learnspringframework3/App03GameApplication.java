package com.chi.learnspringframework3;

import com.chi.learnspringframework.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
class GamingConfiguration {
    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}

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
