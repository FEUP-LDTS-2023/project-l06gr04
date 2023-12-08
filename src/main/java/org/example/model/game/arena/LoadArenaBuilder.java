package org.example.model.game.arena;

import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class LoadArenaBuilder extends ArenaBuilder {

    private final int arenaNumber;

    public LoadArenaBuilder(int arenaNumber) {
        this.arenaNumber = arenaNumber;
    }

    @Override
    protected int getWidth() {
        return 120;
    }

    @Override
    protected int getHeight() {
        return 40;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int col = 0; col < getWidth(); col++) {
            walls.add(new Wall(col, 0));
            walls.add(new Wall(col, getHeight() - 1));
        }
        for (int row = 1; row < getHeight() - 1; row++) {
            walls.add(new Wall(0, row));
            walls.add(new Wall(getWidth() - 1, row));
        }
        return walls;
    }

    @Override
    protected List<Tower> createTowers() {
        List<Tower> towers = new ArrayList<>();
        switch (arenaNumber) {
            case 1:
                towers.add(new MageTower(25, 22));
                towers.add(new ArcherTower(40, 20));
                towers.add(new CanonTower(10, 30));
                break;
            case 2:
                towers.add(new MageTower(30, 15));
                towers.add(new ArcherTower(45, 25));
                towers.add(new CanonTower(20, 35));
                break;
            case 3:
                towers.add(new MageTower(20, 18));
                towers.add(new ArcherTower(35, 22));
                towers.add(new CanonTower(15, 28));
                break;
        }

        return towers;
    }

    @Override
    protected List<Enemy> createEnemys() {
        List<Enemy> enemies = new ArrayList<>();

        switch (arenaNumber) {
            case 1, 2, 3:
                enemies.add(new Golem(5, 5));
                enemies.add(new Golem(10, 10));
                enemies.add(new Golem(15, 15));

                enemies.add(new Skeleton(20, 20));
                enemies.add(new Skeleton(35, 35));
                enemies.add(new Skeleton(40, 40));
                enemies.add(new Skeleton(45, 45));
                enemies.add(new Skeleton(50, 50));

                enemies.add(new Orc(20, 40));
                enemies.add(new Orc(22, 20));
                break;

        }

        return enemies;
    }

}
