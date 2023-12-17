package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;


public class Projectile extends Element {
    private final int damage;
    private final float speed;
    private float xVelocity;
    private float yVelocity;
    private boolean ativo = true;
    private final Enemy target;
    private boolean alive;
    private long pastTime;
    private final long MAX_LIFETIME = 500;

    public Projectile(int x, int y , Enemy target, float speed, int damage) {
        super(x,y);
        this.speed = speed;
        this.damage = damage;
        this.target= target;
        this.alive=true;
        this.xVelocity=1;
        this.yVelocity=1;
        initialize();
    }

    private void calculateDirection() {


        float totalAllowedMovement= 1.0f;
        float xDistanceFromTarget =Math.abs(target.getX()-getX()-(1/4+1/2));
        float yDistanceFromTarget =Math.abs(target.getY()-getY()-(1/4+1/2));
        float totalDistanceFromTarget= xDistanceFromTarget+yDistanceFromTarget;
        float xPercentOfMovement= xDistanceFromTarget/totalDistanceFromTarget;
        xVelocity=xPercentOfMovement;
        yVelocity=totalAllowedMovement-xPercentOfMovement;
        if(target.getX()<getX()) xVelocity*=-1;
        if(target.getY() < getY()) yVelocity*=-1;
    }
    public void update() {
        if (alive) {
            calculateDirection();
            setX((int) (xVelocity*speed + getX()));
            setY((int) (yVelocity*speed + getY()));
            if (checkCollision(getX() ,getY(), target.getX(), target.getY())) {
                damage();
                alive = false;
            }else if(getTimePassed() > MAX_LIFETIME*5){
                alive = false;
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
        target.damage(damage);
        alive = false;
    }

    public long getTimePassed(){
        return System.currentTimeMillis() - pastTime;
    }
    public void initialize(){
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
    public Position getPosition() {
        return new Position(getX(), getY());
    }

}
