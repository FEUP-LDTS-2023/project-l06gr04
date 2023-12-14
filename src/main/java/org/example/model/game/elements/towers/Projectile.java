package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import static org.example.controller.Clock.Delta;

public class Projectile extends Element {
    private int damage,width,height;
    private float speed,xVelocity, yVelocity;
    private boolean ativo = true;
    //private ArrayList<Projectile> projectiles;
    private Enemy target;
    private boolean alive;
    private int totalTime;
    private long pastTime;
    private int MAX_LIFETIME = 500;
    private int x;
    private int y;

    public Projectile(int x, int y , Enemy target, float speed, int damage) {
        super(x,y);
        this.speed = speed;
        this.damage = damage;
        this.target= target;
        this.alive=true;
        this.xVelocity=1;
        this.yVelocity=1;
        initialize();
        if (target != null ) {
            target.reduceHiddenHealth(damage);
            if (target.getHiddenHealth()<=0) {
                target.die();
            }
        }

    }
    private void calculateDirection() {
        /*
        if (target.getX() < x) {
            xVelocity = -1;
        } else if (target.getX() > x) {
            xVelocity = 1;
        } else {
            xVelocity = 0;
        }

        if (target.getY() < y) {
            yVelocity = -1;
        } else if (target.getY() > y) {
            yVelocity = 1;
        } else {
            yVelocity = 0;
        }*/

        float totalAllowedMovement= 1.0f;
        float xDistanceFromTarget =Math.abs(target.getX()-x-1/4+1/2);
        float yDistanceFromTarget =Math.abs(target.getY()-y-1/4+1/2);
        float totalDistanceFromTarget= xDistanceFromTarget+yDistanceFromTarget;
        float xPercentOfMovement= xDistanceFromTarget/totalDistanceFromTarget;
        xVelocity=xPercentOfMovement;
        yVelocity=totalAllowedMovement-xPercentOfMovement;
        if(target.getX()<x) xVelocity *=-1;
        if(target.getY() < y) yVelocity *=-1;
//        float xDistanceFromTarget = target.getX();
//        float yDistanceFromTarget = target.getY();
//        if(Math.abs(xDistanceFromTarget) > Math.abs(yDistanceFromTarget)){
//            xVelocity = Math.signum(xDistanceFromTarget);
//            yVelocity = 0;
//        }else{
//            xVelocity = 0;
//            yVelocity = Math.signum(yDistanceFromTarget);
//        }
    }
    public void update() {
        if (alive) {
            calculateDirection();

            x+=xVelocity*speed;
            y+=yVelocity*speed;

//            if (xVelocity == -1) {
//                x -= 1;
//            } else if (xVelocity == 1) {
//                x += 1;
//            } else if (yVelocity == -1) {
//                y -= 1;
//            } else if (yVelocity == 1) {
//                y += 1;
//            } else if (yVelocity == 0) {
//                x += xVelocity;
//            } else if (xVelocity == 0) {
//                y += yVelocity;
//            }
            if (checkCollision(x, y, target.getX(), target.getY())) {
                damage();
                alive = false;
                if (target.isDead()) {
                    target.die();
//                    tirar do jogo
                }
            }

        }
    }

    public boolean isAlive() {
        return alive;
    }
    private boolean checkCollision(int x, int y, int x2, int y2) {
        return (x == x2 && (y == y2));
    }

    public void damage() {
        System.out.println("Projectile hit! Damage: " + damage);
        target.damage(damage);
        alive = false;
    }

    public long getTimePassed(){
        return System.currentTimeMillis() - pastTime;
    }
    public void initialize(){
        totalTime = 0;
        pastTime = System.currentTimeMillis();
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
    public Position getPosition() {
        return new Position(x, y);
    }
}
