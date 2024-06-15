package com.chi.learnspringframework;

public class GameRunner {

    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }
    void run() {
        System.out.println("game running " + game);
    }
    
}
