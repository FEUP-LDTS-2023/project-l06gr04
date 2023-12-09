package org.example.model.game.arena;

import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<Wall> walls = createWalls();
        arena.setWalls(walls);
        List<Path> paths = createPaths();
        arena.setPaths(paths);
        Chest chest = createChest();
        arena.setChest(chest);
        arena.setEnemies(createEnemies(arena));
        return arena;
    }

    protected abstract Chest createChest();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Path> createPaths();
    protected abstract List<Enemy> createEnemies(Arena arena);

}