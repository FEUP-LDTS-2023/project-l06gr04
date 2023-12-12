package org.example.model.game.elements.enemys;

import org.example.controller.Clock;
import org.example.model.game.Position;
import org.example.model.game.elements.Element;

public abstract class Enemy extends Element {
    int x, y;
    boolean isDead = false;
    Position position;
    char enemySymbol;
    double speed;
    int totHP;
    int actHP;
    int hiddenHP;
    double angle;
    Double[] path;

    public Enemy(double speed, int totHP, int x, int y){
        super(x,y);
        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
        this.hiddenHP=actHP;
        this.position = new Position(x,y);
    }
    public char getEnemySymbol() {
        return enemySymbol;
    }
    public int getActHP() {
        return this.actHP;
    }
    public double getSpeed() {
        return speed;
    }
    public void hurt(int damage) {
        actHP -= damage;
        if (actHP <= 0)
            die();
    }

    public void die() {
        isDead = true;
        actHP = 0;
    }
    public int getHiddenHealth(){

        return hiddenHP;
    }
    public void reduceHiddenHealth(int damage){
        hiddenHP-=damage;
    }
    public void damage(int amount) {
        actHP-=amount;
        if (actHP<0){
            //die;
        }
    }
    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean b) {
        isDead = b;
    }


    public void moveEnemies(Enemy enemy) {
        switch (enemy.getEnemySymbol()) {
            case 'S':
                moveSkeleton(enemy);
                break;
            case 'G':
                moveGolem(enemy);
                break;
            case 'O':
                moveOrc(enemy);
                break;

        }
    }

    public void moveGolem(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(92, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 41 && position.getY()<21){
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 21 && position.getX()>22 && position.getX()!=92){
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 22 && position.getY()<32 && position.getY()!=6 ) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 32 && position.getX()<92) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 92) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 6 && position.getX()<41) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }

    }

    public void moveSkeleton(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(93, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 40 && position.getY()<20){
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 20 && position.getX()>21 && position.getX()!=93){
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 21 && position.getY()<33 && position.getY()!=7 ) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 33 && position.getX()<93) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 93) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 7 && position.getX()<40) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }
    }

    public void moveOrc(Enemy enemy) {
        Position position = enemy.getPosition();
        Position targetPosition = new Position(91, 5);

        if (!enemy.isDead() && !position.equals(targetPosition)) {
            if (position.getX() == 42 && position.getY() < 22) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 22 && position.getX()> 23 && position.getX() != 91) {
                position = new Position(position.getX() - 1, position.getY());
            } else if (position.getX() == 23 && position.getY() < 31 && position.getY() != 5) {
                position = new Position(position.getX(), position.getY() + 1);
            } else if (position.getY() == 31 && position.getX() < 91) {
                position = new Position(position.getX() + 1, position.getY());
            } else if (position.getX() == 91) {
                position = new Position(position.getX(), position.getY() - 1);
            } else if (position.getY() == 5 && position.getX() < 42) {
                position = new Position(position.getX() + 1, position.getY());
            }

            enemy.setPosition(position);
        }
    }
}