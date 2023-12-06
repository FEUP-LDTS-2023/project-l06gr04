package org.example;

import org.example.gui.Window;
import org.example.states.State;

import java.io.IOException;

public class Game {
    private final Window window;
    private State state;
    public void setState(State state) {
        this.state = state;
    }

    public Game(Window window) {
        this.window = window;
    }

    public static void main(String[] args) throws IOException {
        Window window = new Window();
        Game game = new Game(window);
        game.start();
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, window, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }
            catch (InterruptedException e) {
            }
        }
        window.close();
    }
}