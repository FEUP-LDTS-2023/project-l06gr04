package org.example.controller.game;

import org.example.Game;

import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.states.GameState;

public class TowerPositionsController extends GameController{

    public TowerPositionsController(Arena arena) {
        super(arena);
    }

public void moveNextTowerPosition(){

}
    public void moveLastTowerPosition(){

    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) {
        switch (action) {
            case RIGHT:
                moveNextTowerPosition();
            case LEFT:
                moveLastTowerPosition();
            case C:

            case A:
            case M:

        }
    }
}
