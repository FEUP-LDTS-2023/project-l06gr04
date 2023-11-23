package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

public class MageTower extends Tower {

    public MageTower(){
        super(100, 1, 5, 500);

    }
    @Override
    public void attack(Enemy enemy) {
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }

    @Override
    public int dealDamage() {
        return 20 + getLevel() * 5;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+4);
        setLife(getLife() + 25);
    }
}