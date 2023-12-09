package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public class ArcherTower extends Tower {
    private static final int AT_LIFE = 250;
    private static final int LEVEL = 1;
    private static final int RANGE= 3;
    private static final int COST = 250;
    private final int firingSpeed,damage;
    private float timeSinceLastShoot;
    private ArrayList<Projectile> projectiles;

    public ArcherTower(int x, int y) {
        super(AT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'A';
        this.firingSpeed=3;
        this.damage=60;
        this.projectiles = new ArrayList<Projectile>();


    }

    @Override
    public int dealDamage() {
        return 5 + getLevel() * 5;
    }

    @Override
    protected void shoot(Enemy target) {
        timeSinceLastShoot=0;
        //projectiles.add(new Projectile(x+32,y+32,firingSpeed,damage));
    }

    @Override
    protected int getFiringSpeed() {
        return firingSpeed;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel() + 1);
        setRange(getRange() + 2);
        setLife(getLife() + 50);
    }
}