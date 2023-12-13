package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public class MageTower extends Tower {
    private static final int MT_LIFE = 100;
    private static final int LEVEL = 1;
    private static final int RANGE= 5;
    private static final int COST = 500;
    private final int firingSpeed,damage;
    private float timeSinceLastShoot;
    private ArrayList<Projectile> projectiles;
    public MageTower(int x, int y){
        super(MT_LIFE, LEVEL, RANGE, COST,x,y,new ArrayList<>());
        this.towerSymbol = 'M';
        this.damage=50;
        this.firingSpeed = 4;
        this.timeSinceLastShoot=0;
        setCost(COST);
    }
    @Override
    public void shoot(Enemy target) throws Exception {
        timeSinceLastShoot=0;
        projectiles.add(new Projectile(x+32,y+32,target, firingSpeed,damage));
    }

    @Override
    public int getFiringSpeed() {
        return firingSpeed;
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