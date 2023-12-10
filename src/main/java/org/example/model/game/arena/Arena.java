package org.example.model.game.arena;

import org.example.model.game.Level;
import org.example.model.game.Position;
import org.example.model.game.Score;
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
    private int coins;
    private List<Tower> towers;
    private ArrayList<Enemy> enemies;
    private List<Wall> walls;
    private Score score;
    private Level level;
    private Chest chest;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.level = new Level();
        this.score = new Score();
        this.coins = 500;
        this.enemies = new ArrayList<>();
        this.entries = new ArrayList<>(List.of(new Position(3,19),new Position(14,20),new Position(14,20),new Position(26,24),new Position(34,15),new Position(37,67),new Position(29,85)));
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
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
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
    public void addTowers(Tower tower){
        towers.add(tower);
    }
    public Score getScore() {
        return score;
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
    private final List<Position> entries;

    private int currentEntry = 0;

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public Position getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}