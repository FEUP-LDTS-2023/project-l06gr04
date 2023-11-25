package org.example.model.game.arena;

import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.viewer.game.EnemyViewer;
import org.example.viewer.game.WallViewer;

import java.util.ArrayList;
import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<Wall> walls = createWalls();
        arena.setWalls(walls);
        List<Enemy> enemies = createEnemys();
        arena.setEnemies(enemies);
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    // protected abstract List<Tower> createTowers();

    protected abstract List<Enemy> createEnemys();
    //protected abstract List<Path> createPaths();
    public List<WallViewer> createWallViews(Arena arena) {
        List<WallViewer> wallViews = new ArrayList<>();
        List<Wall> walls = arena.getWalls();

        for (Wall wall : walls) {
            wallViews.add(new WallViewer(wall));
        }

        return wallViews;
    }
    public List<EnemyViewer> createEnemyViews(Arena arena) {
        List<EnemyViewer> enemyViews = new ArrayList<>();
        List<Enemy> enemies = arena.getEnemies();

        for (Enemy enemy : enemies) {
            EnemyViewer enemyView = new EnemyViewer(enemy);
            enemyViews.add(enemyView);
        }

        return enemyViews;
    }
}