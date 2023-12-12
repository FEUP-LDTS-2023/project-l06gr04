package org.example.states;

import org.example.Game;
import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.controller.game.EnemyController;
import org.example.controller.game.TowerController;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    private EnemyController enemyController;
    private TowerController towerController;

    private long TIME_FIXED = 500;
    private long totalTime, pastTime;
    Window window;

    public GameState(Arena arena) throws Exception {
        super(arena);
        enemyController = new EnemyController(arena);
        towerController = new TowerController(arena);
        initialize();
    }

    public void initialize() throws Exception {
        totalTime = 0;
        pastTime = System.currentTimeMillis();
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
    public void update(Game game) throws Exception {
        enemyController.step(game, null, System.currentTimeMillis());
        if(getModel().getTowers() != null){
            for(Tower tower : towerController.getTowerList()){
                tower.setPosition(tower.getPosition());
            }
        }
    }
    @Override
    public void step(Game game, Window window, long time) throws Exception {
        if (window.processKey()==WindowInterface.KEY.QUIT) {
            game.setState(new MenuState(new Menu()));
            return;
        }
        totalTime += getTimePassed();
        while(totalTime >=TIME_FIXED){
            update(game);
            totalTime -= TIME_FIXED;
        }
        getViewer().draw(window);
    }
    public long getTimePassed() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - pastTime;
        pastTime = currentTime;
        return timePassed;
    }
}