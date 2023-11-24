package org.example;

import org.example.gui.Window;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoadArenaBuilder;

import java.io.IOException;

public class Game {
    private Window window;

    public Game() throws IOException {
        LoadArenaBuilder arenaBuilder = new LoadArenaBuilder();
        Arena arena = arenaBuilder.createArena();
        this.window = new Window(arena);
    }

    public static void main(String[] args) throws IOException {
        new Game().window.run();
    }
}
