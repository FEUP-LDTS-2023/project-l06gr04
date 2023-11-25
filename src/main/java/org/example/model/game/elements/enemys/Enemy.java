package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.Element;

public abstract class Enemy extends Element {
    int x, y;
    Position position;
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
    public void setX(int newx){
        position = new Position(newx,y);
    }
    public void setY(int newy){
        position = new Position(x, newy);
    }
    @Override
    public Position getPosition() {
        return this.position;
    }

}