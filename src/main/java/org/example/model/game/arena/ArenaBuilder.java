package org.example.model.game.arena;

import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.viewer.game.EnemyViewer;
import org.example.viewer.game.TowerViewer;
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
        List<Tower> towers = createTowers();
        arena.setTowers(towers);
//        List<Path> paths = createPaths();
//        arena.setPaths(paths);
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Tower> createTowers();

    protected abstract List<Enemy> createEnemys();
   // protected abstract List<Path> createPaths();
    public List<WallViewer> createWallViews(Arena arena) {
        List<WallViewer> wallViews = new ArrayList<>();
        List<Wall> walls = arena.getWalls();

        for (Wall wall : walls) {
            wallViews.add(new WallViewer());
        }

        return wallViews;
    }
    public List<EnemyViewer> createEnemyViews(Arena arena) {
        List<EnemyViewer> enemyViews = new ArrayList<>();
        List<Enemy> enemies = arena.getEnemies();

        for (Enemy enemy : enemies) {
            EnemyViewer enemyView = new EnemyViewer();
            enemyViews.add(enemyView);
        }

        return enemyViews;
    }
    public List<TowerViewer> createTowerViews(Arena arena){
        List<TowerViewer> towerViews = new ArrayList<>();
        List<Tower> towers = arena.getTowers();
        for(Tower tower : towers){
            TowerViewer towerView = new TowerViewer();
            towerViews.add(towerView);
        }
        return towerViews;
    }
//    public List<PathViewer> createPathViews(Arena arena){
//        List<PathViewer> pathViews = new ArrayList<>();
//        List<Path> paths = arena.getPaths();
//        for(Path path : paths){
//            PathViewer pathView = new PathViewer(path);
//            pathViews.add(pathView);
//        }
//        return pathViews;
//    }
}