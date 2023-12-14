package org.example.model.game.elements.towers;


import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.List;

public class MageTower extends Tower {
    private static final int MT_LIFE = 100;
    private static final int LEVEL = 1;
    private static final int RANGE= 10;
    private static final int COST = 500;
    private final int firingSpeed,damage;
    private float timeSinceLastShoot;
    private List<Projectile> projectiles;
    public MageTower(int x, int y){
        super(MT_LIFE, LEVEL, RANGE, COST,x,y,new ArrayList<>());
        this.towerSymbol = 'M';
        this.damage=50;
        this.firingSpeed = 4;
        this.timeSinceLastShoot=0;
        this.projectiles = new ArrayList<Projectile>();
        setCost(COST);
    }
    @Override
    public void shoot(Enemy target) throws Exception {
        Projectile tiro = new Projectile(x,y,target,firingSpeed,damage);
        projectiles.add(tiro);
        getProjectiles().add(tiro);
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