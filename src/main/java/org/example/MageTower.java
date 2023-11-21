package org.example;

public class MageTower implements Tower {
    private int level = 1;
    private int range = 5;
    private int cost = 500;
    @Override
    public void atack(Enemy enemy) {
        if (isInRange(enemy)) {
            int damage = dealDamage();
        }
    }

    @Override
    public int dealDamage() {
        return 10 + level * 5;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public boolean isInRange(Enemy enemy) {
        return false;
    }

    @Override
    public void upgrade() {
        level++;
        range+=2;
    }
    @Override
    public int cost(){
        return cost;
    }
}