package org.example;

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

    boolean isInRange(Enemy enemy) {
        return false;
    }

    int getLife() {
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
    int getLevel(){
        return level;
    }
    int getRange(){
        return range;
    }
    int cost(){
        return cost;
    }
}
