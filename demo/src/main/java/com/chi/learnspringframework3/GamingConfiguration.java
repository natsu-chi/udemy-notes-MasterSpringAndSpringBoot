package com.chi.learnspringframework3;

import com.chi.learnspringframework.GameRunner;
import com.chi.learnspringframework.GamingConsole;
import com.chi.learnspringframework.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
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
