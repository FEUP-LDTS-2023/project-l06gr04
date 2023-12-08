package org.example.model.game.elements.enemys;

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
    double angle;
    Double[] path;

    public Enemy(double speed, int totHP, int x, int y){
        super(x,y);
        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
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

    void die() {
        isDead = true;
        actHP = 0;
    }
    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean b) {
        isDead = b;
    }
}