package org.example.model.game.elements.enemys;

import org.example.model.game.arena.Point;
import org.example.model.game.elements.Element;

public abstract class Enemy extends Element {
    Point position;
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
    }

    public int getActHP() {
        return this.actHP;
    }

    public void hurt(int damage) {
        actHP -= damage;
        if (actHP <= 0)
            die();
    }

    void die() {
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    @Override
    public Point getPosition() {
        return this.position;
    }

}