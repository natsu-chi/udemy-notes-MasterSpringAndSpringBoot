package com.chi.learnspringframework;

public class App01GameApplication {
    public static void main(String[] args) {
        
        var marioGame = new MarioGame();

        var runner = new GameRunner(marioGame);

        runner.run();
       
    }
}
