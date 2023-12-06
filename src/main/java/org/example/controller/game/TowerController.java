package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;

import java.io.IOException;

public class TowerController extends GameController{
    public TowerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {

    }
}
