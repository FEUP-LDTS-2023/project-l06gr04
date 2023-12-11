package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

import static org.example.controller.Clock.Delta;

public class Projectile{
    private int damage,width,height;
    private float speed,x,y,xVelocity, yVelocity;
    private boolean ativo = true;
    //private ArrayList<Projectile> projectiles;
    private Enemy target;
    private boolean alive;

    public Projectile(float x,float y,Enemy target, float speed, int damage) {
        this.x=x;
        this.y=y;
        this.speed = speed;
        this.damage = damage;
        this.target= target;
        this.alive=true;
        this.xVelocity=0f;
        this.yVelocity=0f;

    }
    private void calculateDirection(){
        float totalAllowedMovement= 1.0f;
        float xDistanceFromTarget =Math.abs(target.getX()-x-1/4+1/2);
        float yDistanceFromTarget =Math.abs(target.getY()-y-1/4+1/2);
        float totalDistanceFromTarget= xDistanceFromTarget+yDistanceFromTarget;
        float xPercentOfMovement= xDistanceFromTarget/totalDistanceFromTarget;
        xVelocity=xPercentOfMovement;
        yVelocity=totalAllowedMovement-xPercentOfMovement;
        if(target.getX()<x) xVelocity *=-1;
        if(target.getY() < y) yVelocity *=-1;
    }
    public void update(){
        if(alive){
            calculateDirection();
            x+=xVelocity*speed*Delta();
            y+=yVelocity*speed*Delta();
            /*if(CheckCollision(x,y,target.getX(),target.getY())){
                damage();
            }*/
        }
    }
    private boolean CheckCollision(float x1, float y1, float x2, float y2){
        if(x1>x2 && x1<x2+1 && y1>y2 && y1<y2+1){
            return true;
        }
        return false;
    }
    public void damage(){
        target.damage(damage);
        alive=false;
    }

    public boolean isActive() {
        return ativo;
    }

    public void setActive(boolean ativo) {
        this.ativo = ativo;
    }

    public int getDmg() {
        return damage;
    }
    public Enemy getTarget(){
        return target;
    }
    public void setAlive(boolean status){
        alive=status;
    }
}
