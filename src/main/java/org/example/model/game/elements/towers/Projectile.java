package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

import static org.example.controller.Clock.Delta;

public class Projectile{
    private int damage,width,height;
    private float speed,xVelocity, yVelocity;
    private int x,y;
    private boolean ativo = true;
    //private ArrayList<Projectile> projectiles;
    private Enemy target;
    private boolean alive;
    private int totalTime;
    private long pastTime;

    public Projectile(int x,int y,Enemy target, float speed, int damage) {
        this.x=x;
        this.y=y;
        this.speed = speed;
        this.damage = damage;
        this.target= target;
        this.alive=true;
        this.xVelocity=1;
        this.yVelocity=1;
        if (target != null) {
            target.reduceHiddenHealth(damage);
            if (target.getHiddenHealth()<=0) {
                target.die();
            }
        }

    }
    private void calculateDirection() {
        if (target.getX() < x) {
            xVelocity *= -1;
        }

        if (target.getY() < y) {
            yVelocity *= -1;
        }
        if(target.getY() ==y){
            yVelocity=0;
        }
        if(target.getX() ==x){
            xVelocity=0;
        }
//        float totalAllowedMovement= 1.0f;
//        float xDistanceFromTarget =Math.abs(target.getX()-x-1/4+1/2);
//        float yDistanceFromTarget =Math.abs(target.getY()-y-1/4+1/2);
//        float totalDistanceFromTarget= xDistanceFromTarget+yDistanceFromTarget;
//        float xPercentOfMovement= xDistanceFromTarget/totalDistanceFromTarget;
//        xVelocity=xPercentOfMovement;
//        yVelocity=totalAllowedMovement-xPercentOfMovement;
//        if(target.getX()<x) xVelocity *=-1;
//        if(target.getY() < y) yVelocity *=-1;
    }
    public void update() {
        if (alive) {
            calculateDirection();
//            x+=xVelocity;
//            y+=yVelocity;

            if(xVelocity == -1) {
                x -= 1;
            }else if(xVelocity==1){
                x+= 1;
            }
            else if(yVelocity == -1) {
                y -=1;
            }else if(yVelocity==1){
                y+=1;
            }else if(yVelocity==0){
                x+=xVelocity;
            }else if(xVelocity==0){
                y+=yVelocity;
            }
            if (checkCollision(x, y, target.getX(), target.getY())) {
                damage();
                alive=false;
                if (target.isDead()){
                    target.die();
                    //tirar do jogo
                }

            }
        }
    }
    boolean isAlive() {
        return alive;
    }
    private boolean checkCollision(int x1, int y1, int x2, int y2) {
        return (x1 == x2 && (y1 == y2));
    }

    public void damage() {
        System.out.println("Projectile hit! Damage: " + damage);
        target.damage(damage);
        alive = false;
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
