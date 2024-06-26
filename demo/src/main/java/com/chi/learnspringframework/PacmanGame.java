package com.chi.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacmanGame")
public class PacmanGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up - PacmanGame");
    }

    @Override
    public void down() {
        System.out.println("down - PacmanGame");
    }

    @Override
    public void left() {
        System.out.println("left - PacmanGame");
    }

    @Override
    public void right() {
        System.out.println("right - PacmanGame");
    }
    
}
