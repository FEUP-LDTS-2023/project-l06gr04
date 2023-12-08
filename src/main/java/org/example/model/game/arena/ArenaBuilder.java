package org.example.model.game.arena;

import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<Wall> walls = createWalls();
        arena.setWalls(walls);
        List<Enemy> enemies = createEnemys();
        arena.setEnemies(enemies);
        List<Tower> towers = createTowers();
        arena.setTowers(towers);
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Tower> createTowers();

    protected abstract List<Enemy> createEnemys();

}