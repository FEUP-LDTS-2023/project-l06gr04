package org.example;

public abstract class Enemy {
    int x, y;
    double speed;
    int totHP;
    int actHP;
    double angle;
    Double[] path;

    public Enemy(double speed, int totHP, int x, int y){
        this.speed = speed;
        this.totHP = totHP;
        actHP = totHP;
        this.x = x;
        this.y = y;
    }

    public void hurt(int damage)
    {
        actHP -= damage;
        if(actHP <= 0)
            die();
    }

    void die() {
    }
}
