package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Enemy enemy : getModel().getEnemies())
                moveMonster(enemy, enemy.getPosition()/*dar movivento aos enemys*/);
            this.lastMovement = time;
        }
    }
    boolean placeOrc(Position position) {
        for(Enemy enemy : getModel().getEnemies())
            if(getModel().isEmpty(position) && enemy.getEnemySymbol() == 'O'){
                enemy.setPosition(position);
                return true;
            }
        return false;
    }
    boolean placeSkeleton(Position position) {
        for(Enemy enemy : getModel().getEnemies())
            if(getModel().isEmpty(position) && enemy.getEnemySymbol() == 'S'){
                enemy.setPosition(position);
                return true;
            }
        return false;
    }
    boolean placeGolem(Position position) {
        for(Enemy enemy : getModel().getEnemies())
            if(getModel().isEmpty(position) && enemy.getEnemySymbol() == 'G'){
                enemy.setPosition(position);
                return true;
            }
        return false;
    }
    private void moveMonster(Enemy enemy, Position position) {
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
        Position position = enemy.getPosition();
        while(enemy.isDead()==false && enemy.getPosition()!=(new Position(96,6))) {
            while (enemy.getPosition().getX() != 44) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 22) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 22) {
                enemy.setPosition(new Position(position.getX() - 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 33) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 95) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 6) {
                enemy.setPosition(new Position(position.getX(), position.getY() - 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveSkeleton(Enemy enemy) {
        double movementDelay = 1000 / enemy.getSpeed();
        Position position = enemy.getPosition();
        while(enemy.isDead()==false && enemy.getPosition()!=(new Position(96,6))) {
            while (enemy.getPosition().getX() != 43) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 21) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 21) {
                enemy.setPosition(new Position(position.getX() - 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 34) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 94) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 6) {
                enemy.setPosition(new Position(position.getX(), position.getY() - 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveOrc(Enemy enemy) {
        double movementDelay = 1000 / enemy.getSpeed();
        Position position = enemy.getPosition();
        while(enemy.isDead()==false && enemy.getPosition()!=(new Position(96,6))) {
            while (enemy.getPosition().getX() != 45) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 23) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 23) {
                enemy.setPosition(new Position(position.getX() - 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 32) {
                enemy.setPosition(new Position(position.getX(), position.getY() + 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getX() != 96) {
                enemy.setPosition(new Position(position.getX() + 1, position.getY()));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (enemy.getPosition().getY() != 6) {
                enemy.setPosition(new Position(position.getX(), position.getY() - 1));
                try {
                    Thread.sleep((long) movementDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
