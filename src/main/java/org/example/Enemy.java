package org.example;
import java.awt.Point;

public abstract class Enemy {
    double speed;
    int totHP;
    int actHP;
    double angle;
    Double[] path;

    public Enemy(double speed, int totHP){

        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
    }

    public void hurt(int damage) {
        actHP -= damage;
        if (actHP <= 0)
            die();
    }

    void die() {
    }
}
