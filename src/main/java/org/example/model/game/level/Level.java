public abstract class Level {
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

    public void increaseEnemyCount(int amount) {
        enemyCount += amount;
    }

    public void decreaseEnemyCount(int amount) {
        enemyCount = Math.max(0, enemyCount - amount);
    }

    public boolean isLevelComplete() {
        return enemyCount == 0;
    }

    // Métodos abstratos que devem ser implementados pelas subclasses
    public abstract void someAbstractMethod();

    // Outros métodos conforme necessário
}
