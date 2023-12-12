package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;
import java.util.List;

import static org.example.controller.Clock.Delta;

public abstract class Tower extends Element {
    private long lastUpdateTime;
    Position position;
    char towerSymbol;
    int x,y;
    int life;
    int level;
    int range;
    int cost;
    private Arena arena;
    List<Enemy> enemies;
    private float angle, timeSinceLastShoot;
    private Enemy target;
    private boolean targeted;
    private ArrayList<Projectile> projectiles;
    public Tower(int life, int level, int range, int cost, int x, int y, List<Enemy> enemies){
        super(x,y);
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.targeted=false;
        this.position = new Position(x,y);
        this.timeSinceLastShoot=0f;
        this.projectiles=new ArrayList<Projectile>();
        this.enemies= enemies;
        this.lastUpdateTime = System.currentTimeMillis();
        /*if (targeted) {
            this.target=getTarget();
            this.angle = calculateAngle();
        }*/
    }

   /* private float calculateAngle(){
        double angleTemp=Math.atan2(target.getY()-y, target.getX()-x );
        return (float) Math.toDegrees(angleTemp) -90;
    }*/


    protected abstract void shoot(Enemy target);

    protected abstract int getFiringSpeed();

    public boolean isInRange(Enemy enemy) {
        float xDistance = Math.abs(enemy.getPosition().getX() - position.getX());
        float yDistance = Math.abs(enemy.getPosition().getY() - position.getY());

        if (xDistance < range && yDistance < range) {
            return true;
        }
        return false;
    }
    public float findDistance(Enemy enemy) {
        float xDistance= Math.abs(enemy.getX()-x);
        float yDistance= Math.abs(enemy.getY()-y);
        return xDistance+yDistance;
    }
    public int getLife() {
        return life;
    }

    public char getTowerSymbol() {
        return towerSymbol;
    }
    public void attack(Enemy enemy){
        if (isInRange(enemy)) {
            int damage = dealDamage();
            enemy.hurt(damage);
        }
    }
    private Enemy acquireTarget() {
        Enemy closest = null;
        float closestDistance = 100000;

        System.out.println("Number of enemies: " + enemies.size());

        for (Enemy e : enemies) {
            System.out.println("Checking enemy at position: " + e.getPosition());
            System.out.println("Is in range: " + isInRange(e));
            System.out.println("Distance: " + findDistance(e));
            System.out.println("Hidden health: " + e.getHiddenHealth());

            if (isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth() > 0) {
                closestDistance = findDistance(e);
                closest = e;
            }
        }

        if (closest != null) {
            targeted = true;
            System.out.println("Target acquired: " + closest.getPosition());
        } else {
            System.out.println("No target acquired.");
        }

        return closest;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
    public abstract ArrayList<Projectile> getProjectiles();

    public abstract void upgrade();
    abstract int dealDamage();
    public int getLevel(){
        return level;
    }
    public int getRange(){
        return range;
    }
    int cost(){
        return cost;
    }
    void setLevel(int level){
        this.level = level;
    }
    void setRange(int range){
        this.range = range;
    }
    void setLife(int life){
        this.life = life;
    }
    void setCost(int cost){
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public void update(){
        long currentTime = System.currentTimeMillis();
        float deltaTime = (currentTime - lastUpdateTime) / 1000.0f;
        if (!targeted) {
            target = acquireTarget();
            System.out.println("Acquired target: " + target);
        }

        if (target == null || target.isDead()) {
            targeted = false;
            System.out.println("Target is null or dead");
        }
        timeSinceLastShoot += deltaTime;
        if(targeted && findDistance(target) < range && timeSinceLastShoot > getFiringSpeed()){
            shoot(target);
            timeSinceLastShoot = 0;
        }
        lastUpdateTime = currentTime;

    }

    public void setEnemyList(ArrayList<Enemy> enemies) {
        this.enemies=enemies;
    }
}
