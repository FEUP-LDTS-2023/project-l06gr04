package org.example.controller.game;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.TowerPositions;
import org.example.states.GameState;
import org.example.model.game.arena.Arena;

import java.io.IOException;

public class TowerPositionsController extends GameController {
    public TowerPositionsController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case M:
                //game.setState(new GameState(new LoaderArenaBuilder().updateArena()));
            case C:
                //game.setState(new GameState(new LoaderArenaBuilder().updateArena()));
            case A:
                //game.setState(new GameState(new LoaderArenaBuilder().updateArena()));
        }
    }
}
