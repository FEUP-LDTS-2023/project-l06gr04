package org.example.model.game.elements.towers;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
import org.example.model.game.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.enemys.Enemy;

import java.util.ArrayList;

public abstract class Tower extends Element {
    Position position;
    char towerSymbol;
    int x,y;
    int life;
    int level;
    int range;
    int cost;
    ArrayList<Enemy> enemies;
    public Tower(int life, int level, int range, int cost, int x, int y, ArrayList<Enemy> enemies){
        super(x,y);
        this.life = life;
        this.level = level;
        this.range = range;
        this.cost = cost;
        this.position = new Position(x,y);
        this.enemies=enemies;
    }
    public boolean isInRange(Enemy enemy) {
        int distance = (int) Math.sqrt(Math.pow(enemy.getX() - this.x, 2) + Math.pow(enemy.getY() - this.y, 2));
        return distance <= this.range;
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
    private Enemy acquireTarget(){
        Enemy closest= null;
        float maxdistance=100000;
        //for (Enemy e: enemies){
        //if(
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
}
