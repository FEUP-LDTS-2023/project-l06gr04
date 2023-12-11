package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public class CanonTower extends Tower{
    private static final int CT_LIFE = 300;
    private static final int LEVEL = 1;
    private static final int RANGE= 2;
    private static final int COST = 100;
    private int firingSpeed, damage;
    private float timeSinceLastShoot;
    private ArrayList<Projectile> projectiles;
    public CanonTower(int x, int y) {
        super(CT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'C';
        this.firingSpeed=3;
        this.damage=60;
        this.projectiles = new ArrayList<Projectile>();
        this.timeSinceLastShoot=0;
    }

    @Override
    public void shoot(Enemy target){
        timeSinceLastShoot=0;
        //projectiles.add(new Projectile(x+32,y+32,firingSpeed,damage));
    }

    @Override
    public int getFiringSpeed() {
        return firingSpeed;
    }

    @Override
    public int dealDamage() {
        return 1 + getLevel() * 5;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+1);
        setLife(getLife() +100);
    }
}
