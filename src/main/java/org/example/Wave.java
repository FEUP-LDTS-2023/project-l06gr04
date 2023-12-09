package org.example;
import java.util.Random;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.*;

import static org.example.Clock.*;
import java.util.ArrayList;

public class Wave {
    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;
    private int enemiesPerWave;
    public Wave(Enemy enemyType.float spawnTime, int enemiesPerWave){
        this.enemyType=enemyType;
        this.spawnTime=spawnTime;
        timeSinceLastSpawn=0;
        enemyList= new ArrayList<Enemy>();
        spawn();
    }
    public void update(){
        timeSinceLastSpawn+= Delta();
        if(timeSinceLastSpawn>spawnTime){
            spawn();
            timeSinceLastSpawn=0;
        }
        for (Enemy e: enemyList){
            //e.update(); e.draw();

        }
    }
    private void spawn() {
        Random random = new Random();
        int enemyTypeIndex = random.nextInt(3);
        for (int i=0; i<enemiesPerWave;i++){
            Enemy newEnemy = createRandomEnemy(enemyTypeIndex);
            enemyList.add(newEnemy);
        }
    }

    private Enemy createRandomEnemy(int enemyTypeIndex) {
        switch (enemyTypeIndex) {
            case 0:
                return new Golem(0, 6);
            case 1:
                return new Orc(0, 5);
            case 2:
                return new Skeleton(0, 7);
        }
    }
}
