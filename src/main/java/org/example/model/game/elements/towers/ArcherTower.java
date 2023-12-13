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
        this.firingSpeed=600;
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
        System.out.println("Archer");
        Projectile tiro = new Projectile(x,y,target,firingSpeed,damage);
        System.out.println(target.getHiddenHealth());
        projectiles.add(tiro);


    }
    @Override
    public void updateProjectiles() {
        Iterator<Projectile> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Projectile projectile = iterator.next();
            projectile.update();
            if (!projectile.isActive()) {
                iterator.remove();
            }
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
}