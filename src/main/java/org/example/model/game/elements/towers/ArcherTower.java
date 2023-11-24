package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

public class ArcherTower extends Tower {
    public ArcherTower() {
        super(250, 1, 3, 250,2,1);
    }



    @Override
    public int dealDamage() {
        return 5 + getLevel() * 5;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel() + 1);
        setRange(getRange() + 2);
        setLife(getLife() + 50);
    }
}