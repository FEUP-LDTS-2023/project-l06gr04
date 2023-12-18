package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.List;

public class CanonTower extends Tower{
    private static final int CT_LIFE = 300;
    private static final int LEVEL = 1;
    private static final int RANGE= 20;
    private static final int COST = 100;
    private int firingSpeed, damage;

    public CanonTower(int x, int y) {
        super(CT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'C';
        this.firingSpeed=9;
        this.damage=60;

        setCost(COST);
    }

    @Override
    public void shoot(Enemy target){
        target.reduceHiddenHealth(damage);

    }

    @Override
    public int getFiringSpeed() {
        return firingSpeed;
    }



    @Override
    public int getDamage() {
        return damage;
    }



    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+1);
        setLife(getLife() +100);
    }

}
