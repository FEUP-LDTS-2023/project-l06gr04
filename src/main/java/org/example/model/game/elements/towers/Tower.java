package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

public abstract class Tower {
    int life;
    int level;
    int range;
    int cost;

    public Tower(int life, int level, int range, int cost){
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
    }

    public boolean isInRange(Enemy enemy) {
        return true;
    }

    public int getLife() {
        return life;
    }

    void atack(Enemy enemy){
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
}
