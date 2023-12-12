package org.example.model.game.arena;

import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;

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


}