package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.Iterator;

public class ArcherTower extends Tower {
    private static final int AT_LIFE = 250;
    private static final int LEVEL = 1;
    private static final int RANGE= 30;
    private static final int COST = 250;
    private final int firingSpeed,damage;
    private float timeSinceLastShoot;
    private ArrayList<Projectile> projectiles;

    public ArcherTower(int x, int y) {
        super(AT_LIFE, LEVEL, RANGE, COST, x, y,new ArrayList<>());
        this.towerSymbol = 'A';
        this.firingSpeed=10;
        this.damage=60;
        this.projectiles = new ArrayList<Projectile>();
        setCost(COST);


    }

    @Override
    public int dealDamage() {
        return 5 + getLevel() * 5;
    }

    @Override
    public void shoot(Enemy target) {
        timeSinceLastShoot=0;
        System.out.println("Archer");
        projectiles.add(new Projectile(x+32,y+32,target,firingSpeed,damage));
        for (Projectile projectile : projectiles) {
            projectile.update();
        }
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
    @Override
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    @Override
    public void update() {
        super.update(); // Call the base class update method

        Iterator<Projectile> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Projectile projectile = iterator.next();
            projectile.update();
            if (!projectile.isActive()) {
                iterator.remove();  // Remove inactive projectiles
            }
        }
    }
}