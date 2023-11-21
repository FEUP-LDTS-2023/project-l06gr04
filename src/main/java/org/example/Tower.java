package org.example;

public interface Tower {
    boolean isInRange(Enemy enemy);
    void atack(Enemy enemy);
    void upgrade();
    int dealDamage();
    int getLevel();
    int getRange();
    int cost();
}
