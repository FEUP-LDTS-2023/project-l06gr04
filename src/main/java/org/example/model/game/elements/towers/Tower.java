package org.example.model.game.elements.towers;

import org.example.model.game.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

import static org.example.controller.Clock.Delta;

public abstract class Tower extends Element {
    Position position;
    char towerSymbol;
    int x,y;
    int life;
    int level;
    int range;
    int cost;
    ArrayList<Enemy> enemies;
    private float angle, timeSinceLastShoot;
    private Enemy target;
    private boolean targeted;
    private ArrayList<Projectile> projectiles;
    public Tower(int life, int level, int range, int cost, int x, int y, ArrayList<Enemy> enemies){
        super(x,y);
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.targeted=false;
        this.position = new Position(x,y);
        this.timeSinceLastShoot=0f;
        this.projectiles=new ArrayList<Projectile>();
        this.enemies=enemies;
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
        float xDistance = Math.abs(enemy.getX()-x);
        float yDistance= Math.abs(enemy.getY()-y);
        if(xDistance <range && yDistance< range)
            return true;
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
        for (Enemy e : enemies) {
            if (isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth() > 0) {
                closestDistance = findDistance(e);
                closest = e;
            }

        }
        if (closest!=null) {
            targeted=true;
        }
        return closest;
    }

    abstract void upgrade();
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

    public void setEnemyList(ArrayList<Enemy> enemies) {
        this.enemies=enemies;
    }
}
