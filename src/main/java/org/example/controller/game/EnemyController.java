package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {
    private long lastMovement;
    private List<Enemy> activeEnemies = new ArrayList<>();

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
    public boolean canPlaceEnemy(Position position) {
        for (Enemy enemy : getModel().getEnemies()) {
            if (enemy.getPosition().equals(position)) {
                return false;
            }
        }
        return getModel().isEmpty(position);
    }

    public void placeOrc(Position position) {
        if (canPlaceEnemy(position)) {
            Orc orc = new Orc(0, 70);
            orc.setPosition(position);
            activeEnemies.add(orc);
            moveMonster(orc, orc.getPosition());
            getModel().getEnemies().add(orc);
        }
    }

    public void placeSkeleton(Position position) {
        if (canPlaceEnemy(position)) {
            Skeleton skeleton = new Skeleton(0, 70);
            skeleton.setPosition(position);
            activeEnemies.add(skeleton);
            moveMonster(skeleton, skeleton.getPosition());
            getModel().getEnemies().add(skeleton);
        }
    }

    public void placeGolem(Position position) {
        if (canPlaceEnemy(position)) {
            Golem golem = new Golem(position.getX(), position.getY());
            activeEnemies.add(golem);
            moveMonster(golem, golem.getPosition());
            getModel().getEnemies().add(golem);
        }
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
        Position targetPosition = new Position(96,6);
        Position position = enemy.getPosition();
        while(enemy.getPosition().getX()!= 45){
            enemy.setPosition(new Position(position.getX() + 1, position.getY()));
            try {
                Thread.sleep((long) movementDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
        //        while (!enemy.isDead() && !position.equals(targetPosition)) {
//            if (position.getX() < targetPosition.getX()) {
//                position = new Position(position.getX() + 1, position.getY());
//            } else if (position.getX() > targetPosition.getX()) {
//                position = new Position(position.getX() - 1, position.getY());
//            } else if (position.getY() < targetPosition.getY()) {
//                position = new Position(position.getX(), position.getY() + 1);
//            } else if (position.getY() > targetPosition.getY()) {
//                position = new Position(position.getX(), position.getY() - 1);
//            }
//
//            enemy.setPosition(position);
//
//            try {
//                Thread.sleep((long) movementDelay);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (position.equals(targetPosition)) {
//            enemy.die();
//        }
//    }

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
