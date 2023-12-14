package org.example.controller.game;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Position;
import org.example.model.game.Score;
import org.example.model.game.Wave;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.controller.Clock;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.viewer.game.GameViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {
    public List<Enemy> enemies ;
    private Level level;
    private ScoreController scoreController;
    public ArrayList<Enemy> enimigos;
    private long lastMovement;
    private Arena arena;
    private LevelController levelController;
    private Wave wave;
    private Score scoreModel;


    public EnemyController(Arena arena) {
        super(arena);
        this.arena= arena;
        this.enemies = new ArrayList<>();
        this.lastMovement = 0;
        this.level= new Level();
        this.scoreModel = arena.getScore();
        this.levelController= new LevelController(arena,level);
        this.wave= new Wave();
        wave.spawn(level.getLevel());
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            moveEnemies();

            if (enemies.isEmpty()) {
                level.updateLevel(scoreModel);
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
            level.updateLevel(scoreModel);
            if (enemy.isDead()) {
                deadEnemies.add(enemy);
                updateScore(enemy);
            }   
        }
        enemies.removeAll(deadEnemies);

    }
    private void updateScore(Enemy enemy) {
        switch (enemy.getEnemySymbol()) {
            case 'S':
                System.out.println("Scoring for Skeleton...");
                scoreModel.incrementScore(10 + level.getLevel() * 2);
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 25);
                Position deathPosition = enemy.deathPosition();
                if (deathPosition.getX() == 93 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                }
                break;
            case 'O':
                System.out.println("Scoring for ORC...");
                scoreModel.incrementScore(20 + level.getLevel() * 2);
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 50);
                deathPosition = enemy.deathPosition();
                if (deathPosition.getX() == 91 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                }
                break;
            case 'G':
                System.out.println("Scoring for golem...");
                scoreModel.incrementScore(50 + level.getLevel() * 3);
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 100);
                deathPosition = enemy.deathPosition();
                if (deathPosition.getX() == 92 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                }
                break;
        }
    }
}