package org.example.model.game;
import java.util.Random;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.*;

import static org.example.controller.Clock.*;
import java.util.ArrayList;

public class Wave {
    private float timeSinceLastSpawn, spawnTime;
    private ArrayList<Enemy> enemyList;
    private int enemiesPerWave;
    private boolean waveCompleted;
    public Wave(float spawnTime, int enemiesPerWave){

        this.spawnTime=spawnTime;
        timeSinceLastSpawn=0;
        enemyList= new ArrayList<Enemy>();
        this.waveCompleted=false;
        spawn();
    }
    public void update(){
        boolean allEnemiesDead=true;
        /*
        timeSinceLastSpawn+= Delta();
        if(timeSinceLastSpawn>spawnTime){
            spawn();
            timeSinceLastSpawn=0;
        }
        */

        for (Enemy e: enemyList){
            if(!e.isDead()){
                allEnemiesDead=false;
                //e.update();

            }
            else {
                enemyList.remove(e);
            }

        }
        if (allEnemiesDead){
            waveCompleted=true;
        }
    }
    private void spawn() {
        //Random random = new Random();
        for (int i=0; i<enemiesPerWave;i++){
            enemyList.add(new Orc(0+i,6));
            enemyList.add(new Golem(0+i,7));
            enemyList.add(new Skeleton(0+i,8));
        }
        this.waveCompleted=true;
    }
    /*
    private Enemy createRandomEnemy(int enemyTypeIndex) {
        return switch (enemyTypeIndex) {
            case 0 -> new Golem(0, 6);
            case 1 -> new Orc(0, 5);
            case 2 -> new Skeleton(0, 7);
            default -> new Skeleton(1, 7);
        };
    }
    */

    public boolean isCompleted(){
        return waveCompleted;
    }
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
