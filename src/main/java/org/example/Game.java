package org.example;

import org.example.gui.Window;
import java.io.IOException;

public class Game {

    private final Window window;

    public Game() throws IOException {
        this.window = new Window();
    }

    public static void main(String[] args) throws IOException {
        new Game().window.run();
    }



}