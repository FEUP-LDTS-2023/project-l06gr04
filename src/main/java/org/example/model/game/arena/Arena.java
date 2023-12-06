package org.example.model.game.arena;

import org.example.model.game.Position;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class Arena{
    private List<Path> paths;
    private final int width;
    private final int height;
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Wall> walls;
    private Chest chest;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        //this.paths = new ArrayList<>();
        this.chest = new Chest(width/2, height/2);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }

//    public List<Path> getPaths() {
//        return paths;
//    }
//    public void setPaths(List<Path> paths){
//        this.paths = paths;
//    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public void setTowers(List<Tower> towers){
        this.towers = towers;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
}