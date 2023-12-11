package org.example.controller.game;

import org.example.model.game.Wave;
import org.example.model.game.elements.enemys.Enemy;

public class WaveController {
    private float timeSinceLastWave, timeBetweenEnemies;
    private int waveNumber, enemiesPerWave;
    private Enemy enemytype;
    private Wave currentWave;
    public WaveController( float timeBetweenEnemies, int enemiesPerWave){
        this.timeBetweenEnemies= timeBetweenEnemies;
        this.enemiesPerWave= enemiesPerWave;
        this.timeSinceLastWave=0;
        this.waveNumber=0;
        this.currentWave= newWave();
    }
    public void update(){
        if(!currentWave.isCompleted()){
            currentWave.update();
        }
        else {
            newWave();
        }
    }
    private Wave newWave() {
        waveNumber++;
        System.out.println("Beginning Wave" + waveNumber);
        return new Wave( timeBetweenEnemies, enemiesPerWave);
    }

    public Wave getCurrentWave() {
        return currentWave;
    }
}
