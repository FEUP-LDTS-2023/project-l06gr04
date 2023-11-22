package org.example;

public class CanonTower extends Tower{
    int life;
    int level;
    int range;
    int cost;
    CanonTower(int life, int level, int range, int cost){
        super(300, 1, 2, 100);
    }
    public void atack(Enemy enemy) {
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }
    @Override
    public int dealDamage() {
        return 1 + level * 5;
    }
    @Override
    public void upgrade() {
        level++;
        range+=1;
        life+=100;
    }
}
