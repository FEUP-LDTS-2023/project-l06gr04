package org.example.model.game.arena;

import org.example.model.game.elements.Path;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.util.List;

public class Arena{
    private List<Path> paths;
    private final int width;
    private final int height;
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
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

    public List<Path> getPaths() {
        return paths;
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
}