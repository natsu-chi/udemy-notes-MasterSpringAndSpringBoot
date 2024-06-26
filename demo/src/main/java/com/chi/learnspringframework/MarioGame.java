package com.chi.learnspringframework;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up - MarioGame");
    }

    @Override
    public void down() {
        System.out.println("down - MarioGame");
    }

    @Override
    public void left() {
        System.out.println("left - MarioGame");
    }

    @Override
    public void right() {
        System.out.println("right - MarioGame");
    }
    
}
