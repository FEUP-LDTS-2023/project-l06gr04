package org.example.model.game.arena;

import org.example.model.game.Level;
import org.example.model.game.Position;
import org.example.model.game.Score;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class Arena{
    private List<Path> paths;
    private final int width;
    private final int height;
    private int coins;
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Wall> walls;
    private Score score;
    private Level level;
    private Chest chest;
    private List<TowerPositions> towerPositions;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.level = new Level();
        this.score = new Score();
        this.coins = 500;
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public List<Path> getPaths() {
        return paths;
    }
    public void setChest(Chest chest){
        this.chest = chest;
    }
    public void setScore(Score score){
        this.score = score;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }


    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public void setTowerPositions(List<TowerPositions> towerPositions) {
        this.towerPositions = towerPositions;
    }
    public void setTowers(List<Tower> towers){
        this.towers = towers;
    }
    public void addTowers(Tower tower){
        towers.add(tower);
    }
    public Score getScore() {
        return score;
    }
    public List<TowerPositions> getTowerPositions() {
        return towerPositions;
    }
    public Level getLevel(){
        return level;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public Chest getChest() {
        return chest;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int i) {
        this.coins = i;
    }
}