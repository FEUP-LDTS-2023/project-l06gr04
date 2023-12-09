package org.example.model.game.elements.towers;

import java.util.ArrayList;

public class ArcherTower extends Tower {
    private static final int AT_LIFE = 250;
    private static final int LEVEL = 1;
    private static final int RANGE= 3;
    private static final int COST = 250;
    public ArcherTower(int x, int y) {
        super(AT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'A';


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