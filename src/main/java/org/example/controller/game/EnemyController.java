package org.example.controller.game;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.Wave;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.controller.Clock;
import org.example.model.game.elements.enemys.Orc;
import org.example.viewer.game.GameViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {
    public ArrayList<Enemy> enemies ;
    public ArrayList<Enemy> enimigos;
    private long lastMovement;
    public EnemyController(Arena arena) {
        super(arena);
        Wave wave= new Wave(500, 3);
        enimigos = arena.getEnemies();
        //enemies=wave.getEnemyList();
        //WaveController waveController= new WaveController(500, 3);
        //this.enemies = waveController.getCurrentWave().getEnemyList();
        //arena.setEnemies(enemies);
        this.lastMovement=0;
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
                moveEnemies();
            this.lastMovement = time;
        }
    }

    private void moveEnemies() {
        for (Enemy enemy : enimigos) {
            moveEnemies(enemy);
        }
    }

    private void moveEnemies(Enemy enemy) {
        switch (enemy.getEnemySymbol()) {
            case 'O':
                moveOrc(enemy);
                break;
            case 'S':
                moveSkeleton(enemy);
                break;
            case 'G':
                moveGolem(enemy);
                break;
        }
    }

    private void moveGolem(Enemy enemy) {
        double movementDelay = 1000 / enemy.getSpeed();
        long lastMoveTime = Clock.getTime();
        Position position = enemy.getPosition();
        Position targetPosition = new Position(95, 6);

        while (!enemy.isDead() && !position.equals(targetPosition)) {
            long currentTime = Clock.getTime();
            float deltaTime = Clock.Delta();

            if (currentTime - lastMoveTime >= movementDelay) {
                lastMoveTime = currentTime;

                if (position.getX() == 44) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 24) {
                    position = new Position(position.getX() - 1, position.getY());
                } else if (position.getX() == 22) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 33) {
                    position = new Position(position.getX() + 1, position.getY());
                } else if (position.getX() == 95) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 6) {
                    position = new Position(position.getX() + 1, position.getY());
                }

                enemy.setPosition(position);
            }
        }
    }

    private void moveSkeleton(Enemy enemy) {
        double movementDelay = 1000 / enemy.getSpeed();
        long lastMoveTime = Clock.getTime();
        Position position = enemy.getPosition();
        Position targetPosition = new Position(96, 6);

        while (!enemy.isDead() && !position.equals(targetPosition)) {
            long currentTime = Clock.getTime();
            float deltaTime = Clock.Delta();

            if (currentTime - lastMoveTime >= movementDelay) {
                lastMoveTime = currentTime;

                if (position.getX() == 43) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 25) {
                    position = new Position(position.getX() - 1, position.getY());
                } else if (position.getX() == 23) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 34) {
                    position = new Position(position.getX() + 1, position.getY());
                } else if (position.getX() == 96) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 6) {
                    position = new Position(position.getX() + 1, position.getY());
                }

                enemy.setPosition(position);
            }
        }
    }

    private void moveOrc(Enemy enemy) {
        double movementDelay = 1000 / enemy.getSpeed();
        long lastMoveTime = Clock.getTime();
        Position position = enemy.getPosition();
        Position targetPosition = new Position(94, 6);

        while (!enemy.isDead() && !position.equals(targetPosition)) {
            long currentTime = Clock.getTime();
            float deltaTime = Clock.Delta();

            if (currentTime - lastMoveTime >= movementDelay) {
                lastMoveTime = currentTime;

                if (position.getX() == 45) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 23) {
                    position = new Position(position.getX() - 1, position.getY());
                } else if (position.getX() == 21) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 32) {
                    position = new Position(position.getX() + 1, position.getY());
                } else if (position.getX() == 94) {
                    position = new Position(position.getX(), position.getY() + 1);
                } else if (position.getY() == 6) {
                    position = new Position(position.getX() + 1, position.getY());
                }

                enemy.setPosition(position);
            }
        }
    }
}
