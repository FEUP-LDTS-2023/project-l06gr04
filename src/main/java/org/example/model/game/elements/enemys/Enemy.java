package org.example.model.game.elements.enemys;

public abstract class Enemy{
    int x, y;
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
    public int getActHP(){
        return this.actHP;
    }

    public void hurt(int damage) {
        actHP -= damage;
        if (actHP <= 0)
            die();
    }

    void die() {
    }
}
