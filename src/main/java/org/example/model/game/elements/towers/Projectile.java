package org.example.model.game.elements.towers;

public class Projectile {
    double x, y;
    private int damage;
    private float xSpeed, ySpeed;
    private boolean ativo = true;

    public Projectile(float x, float y, float xSpeed, float ySpeed, int damage) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.damage = damage;
    }
    public void move() {
        this.x += xSpeed;
        this.y += ySpeed;
    }

    public Double getPos_x() {
        return this.x;
    }
    public Double getPos_y() {
        return this.y;
    }

    public void setPos(double x,double y) {
        this.x = x;
        this.y = y;
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
}
