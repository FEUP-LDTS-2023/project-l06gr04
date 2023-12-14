package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.controller.Clock.Delta;

public abstract class
Tower extends Element {
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
    private Enemy target;
    private boolean targeted;

    private long totalTime;
    private long pastTime;
    private List<Projectile> projectiles;

    public Tower(int life, int level, int range, int cost, int x, int y, List<Enemy> enemies ){
        super(x,y);
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.targeted=false;
        this.position = new Position(x,y);
        this.projectiles=new ArrayList<>();
        this.enemies= enemies;
        initialize();

    }


    protected abstract void shoot(Enemy target) throws Exception;

    protected abstract int getFiringSpeed();

    public boolean isInRange(Enemy enemy) {
        float xDistance = Math.abs(enemy.getPosition().getX() - position.getX());
        float yDistance = Math.abs(enemy.getPosition().getY() - position.getY());

        if (xDistance < range && yDistance < range) {
            return true;
        }
        return false;
    }
    public void initialize(){
        totalTime = 0;
        pastTime = System.currentTimeMillis();
    }
    public float findDistance(Enemy enemy) {
        float xDistance= Math.abs(enemy.getX()-getX());
        float yDistance= Math.abs(enemy.getY()-getY());
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

        for (Enemy e : enemies) {

            if (isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth() > 0) {
                closestDistance = findDistance(e);
                closest = e;
            }
        }

        if (closest != null) {
            targeted = true;
        }

        return closest;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }


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
    public void update() throws Exception {
        if (target == null || target.isDead() || !isInRange(target)) {
            targeted = false;
            target = acquireTarget();
        }

        totalTime += getTimePassed();
        if (targeted && findDistance(target) < range && totalTime > getFiringSpeed()) {
            Projectile novo = new Projectile(10,10,target,getFiringSpeed(),dealDamage());
            novo.setX(getX()+1);
            novo.setY(getY()+1);
            projectiles.add(novo);
            shoot(target);

            totalTime -= getFiringSpeed();
        }
        List<Projectile> deadProjectiles = new ArrayList<>();
    }
    private long getTimePassed() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - pastTime;
        pastTime = currentTime;
        return timePassed;
    }


    public void setEnemyList(ArrayList<Enemy> enemies) {
        this.enemies=enemies;
    }
    public void updateProjectiles() {
        List<Projectile> deadProjectiles = new ArrayList<>();

        for (Projectile projectile : projectiles) {
            projectile.update();

            if (!projectile.isAlive()) {
                deadProjectiles.add(projectile);
            }
        }

        projectiles.removeAll(deadProjectiles);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }
}
