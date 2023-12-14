package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.List;

public class CanonTower extends Tower{
    private static final int CT_LIFE = 300;
    private static final int LEVEL = 1;
    private static final int RANGE= 20;
    private static final int COST = 100;
    private static final int UP_COST = 300;
    private int firingSpeed, damage;
    private float timeSinceLastShoot;
    private List<Projectile> projectiles;
    public CanonTower(int x, int y) {
        super(CT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'C';
        this.firingSpeed=5;
        this.damage=60;
        this.projectiles = new ArrayList<Projectile>();
        this.timeSinceLastShoot=0;
        setCost(COST);
    }

    @Override
    public void shoot(Enemy target){
        target.reduceHiddenHealth(damage);

        if (target.getHiddenHealth()<=0) {
            target.die();
        }
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
