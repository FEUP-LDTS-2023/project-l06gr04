package org.example;

public class Level {
    private int levelNumber;
    private int enemyCount;

    public Level(int levelNumber, int enemyCount) {
        this.levelNumber = levelNumber;
        this.enemyCount = enemyCount;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getEnemyCount() {
        return enemyCount;
    }
}
