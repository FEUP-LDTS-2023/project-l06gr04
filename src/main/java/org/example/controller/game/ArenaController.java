package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final TowerController towerController;
    //private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);
        this.towerController = new TowerController(arena);
        //this.enemyController = new EnemyController(arena);

    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws Exception {
        if (getModel() != null) {
            towerController.step(game, action, time);
            //enemyController.step(game, action, time);
        }
    }
}