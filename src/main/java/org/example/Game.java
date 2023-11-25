package org.example;

import org.example.gui.Window;

import java.io.IOException;

public class Game {
    private final Window window;

    public Game(Window window) {
        this.window = window;
    }
    public void run() throws IOException {

        window.draw();
    }

    public static void main(String[] args) throws IOException {
        Window window = new Window();
        Game game = new Game(window);
        game.run();
    }

}