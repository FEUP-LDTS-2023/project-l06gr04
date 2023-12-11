package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.TowerPositions;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final TowerController towerController;
    private final TowerPositionsController towerPositionsController;
    private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);
        this.towerController = new TowerController(arena);
        this.enemyController = new EnemyController(arena);
        this.towerPositionsController=new TowerPositionsController(arena);
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (action == WindowInterface.KEY.QUIT || getModel().getChest().getLife() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            towerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}