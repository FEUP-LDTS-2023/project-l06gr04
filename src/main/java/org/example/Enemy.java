package org.example;
import java.awt.Point;

public abstract class Enemy {
    Point pos;
    double speed;
    int totHP;
    int actHP;
    double angle;
    Double[] path;

    public Enemy(double speed, int totHP, int x, int y){

        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
        this.pos= new Point(x,y);
    }

    public void hurt(int damage) {
        actHP -= damage;
        if (actHP <= 0)
            die();
    }

    void die() {
    }
}
