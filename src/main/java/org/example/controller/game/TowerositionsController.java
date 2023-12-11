package org.example.controller.game;

import org.example.Game;

import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;

public class TowerositionsController extends GameController{

    public TowerositionsController(Arena arena) {
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
