package org.example.model.game;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.*;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private float timeSinceLastSpawn, spawnTime;
    private List<Enemy> enemyList;
    private int enemiesPerWave;
    private boolean waveCompleted;
    public Wave(float spawnTime, int enemiesPerWave){

        this.spawnTime=spawnTime;
        timeSinceLastSpawn=0;
        this.enemyList= new ArrayList<>();
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


        }
        if (allEnemiesDead){
            waveCompleted=true;
        }
    }
    private void spawn() {
        //Random random = new Random();
        //List<Enemy> enemyList1 = new ArrayList<>();
        for (int i=0; i<enemiesPerWave;i++){
            Orc orc = new Orc(0+i,6);
            enemyList.add(orc);
            enemyList.add(new Golem(0+i,7));
            enemyList.add(new Skeleton(0+i,8));
        }
        
        //return enemyList1;
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
    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
