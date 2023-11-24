package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.Position;
public abstract class Tower{
    Position position;
    int x,y;
    int life;
    int level;
    int range;
    int cost;

    public Tower(int life, int level, int range, int cost, int x, int y){
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.position = new Position(x,y);
    }
    public boolean isInRange(Enemy enemy) {
        int distance = (int) Math.sqrt(Math.pow(enemy.getX() - this.x, 2) + Math.pow(enemy.getY() - this.y, 2));
        return distance <= this.range;
    }
    public int getLife() {
        return life;
    }

    public void attack(Enemy enemy){
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }
    abstract void upgrade();
    abstract int dealDamage();
    public int getLevel(){
        return level;
    }
    public int getRange(){
        return range;
    }
    int cost(){
        return cost;
    }
    void setLevel(int level){
        this.level = level;
    }
    void setRange(int range){
        this.range = range;
    }
    void setLife(int life){
        this.life = life;
    }
    public Position getPosition(){
        return this.position;
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
}
