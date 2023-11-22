package org.example;

public class ArcherTower extends Tower{
    int life;
    int level;
    int range;
    int cost;
    public ArcherTower(){
        super(250, 1, 3, 250);

    }
    public void atack(Enemy enemy) {
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }

    @Override
    public int dealDamage() {
        return 5 + level * 5;
    }

    public int getLife(){
        return life;
    }

    public int getLevel() {
        return level;
    }


    public int getRange() {
        return range;
    }


    public boolean isInRange(Enemy enemy) {
        return false;
    }

    @Override
    public void upgrade() {
        level++;
        range+=2;
        life+=50;

    }
}
