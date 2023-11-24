package org.example.model.game.arena;
import org.example.model.game.Point;
import org.example.model.game.elements.*;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setEnemies(createEnemys());
        //arena.setTowers(createTowers());
        arena.setWalls(createWalls());
        //arena.setPaths(createPaths());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    // protected abstract List<Tower> createTowers();

    protected abstract List<Enemy> createEnemys();
    //protected abstract List<Path> createPaths();
}