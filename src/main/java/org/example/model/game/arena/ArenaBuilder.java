package org.example.model.game.arena;

import org.example.Game;
import org.example.controller.game.WaveController;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.viewer.game.GameViewer;

import java.util.ArrayList;
import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<Wall> walls = createWalls();
        arena.setWalls(walls);
        List<TowerPositions> towerPositions= createTowerPositions();
        arena.setTowerPositions(towerPositions);
        List<Path> paths = createPaths();
        arena.setPaths(paths);
        //ArrayList<Enemy> enemies = createEnemies(arena);
        //arena.setEnemies(enemies);
        Chest chest = createChest();
        arena.setChest(chest);
        return arena;
    }

    protected abstract Chest createChest();
    protected abstract List<TowerPositions> createTowerPositions();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Path> createPaths();
    protected abstract ArrayList<Enemy> createEnemies(Arena arena);

}