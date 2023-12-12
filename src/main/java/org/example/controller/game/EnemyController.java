package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Wave;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {

    Wave wave;
    public List<Enemy> enemies ;
    public ArrayList<Enemy> enimigos;
    private long lastMovement;
    private Arena arena;
    private LevelController levelController;
    private Level level;

    public EnemyController(Arena arena) {
        super(arena);
        this.arena= arena;
        this.enemies = new ArrayList<>();
        this.lastMovement = 0;
        this.level= new Level();
        this.levelController= new LevelController(arena,level);
        this.wave= new Wave();
        wave.spawn(level.getLevel());
    }

    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            moveEnemies();

            if (enemies.isEmpty()) {
                List<Enemy> newEnemies = new ArrayList<>();
                wave.spawn(level.getLevel());
                newEnemies=wave.getEnemyList();
                arena.setEnemies(newEnemies);
                enemies = newEnemies;
            }

            this.lastMovement = time;
        }
    }
    private void moveEnemies() {
        List<Enemy> deadEnemies = new ArrayList<>();

        for (Enemy enemy : enemies) {
            enemy.moveEnemies(enemy);

            if (enemy.isDead()) {
                deadEnemies.add(enemy);
            }
        }

        enemies.removeAll(deadEnemies);
    }
}
