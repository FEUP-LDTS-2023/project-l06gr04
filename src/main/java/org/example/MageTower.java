package org.example;

public class MageTower extends Tower {
    int life;
    int level;
    int range;
    int cost;
    public MageTower(){
        super(100, 1, 5, 500);

    }
    public void atack(Enemy enemy) {
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }
    @Override
    public int dealDamage() {
        return 20 + level * 5;
    }

    @Override
    public void upgrade() {
        level++;
        range+=2;
    }
}