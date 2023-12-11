package org.example.controller.game;

import com.googlecode.lanterna.input.KeyType;
import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.Tower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController{
    private List<Position> availablePositions;
    private int currentPositionIndex;
    private int currentTPositionIndex;
    private List<Integer> availableTowers;
    private List<Tower> towerList;
    WaveController waveController;
    //temos de adicionar as torres à lista assim que as criamos para que elas possam ser dadas ao draw
    public TowerController(Arena arena) {
        super(arena);
        availableTowers=new ArrayList<>(List.of(1,2,3));
        availablePositions = new ArrayList<>(List.of(new Position(3,19),new Position(14,20),new Position(14,20),new Position(26,24),new Position(34,15),new Position(37,67),new Position(29,85)));
        currentPositionIndex = 0;
        //WaveController waveController= new WaveController(500, 50);
    }
    public void nextPosition() {
        currentPositionIndex++;
        if(currentPositionIndex==10){
            currentPositionIndex=0;
        }
    }

    public void lastPosition() {
        currentPositionIndex--;
        if(currentPositionIndex==-1){
            currentPositionIndex=9;
        }
    }
    public void nextTPosition() {
        currentPositionIndex++;
        if(currentPositionIndex==3){
            currentPositionIndex=0;
        }
    }

    public void lastTPosition() {
        currentPositionIndex--;
        if(currentPositionIndex==-1){
            currentPositionIndex=2;
        }
    }
    public void updateEnemyLists(){
        for (Tower t: towerList){
            t.setEnemyList(waveController.getCurrentWave().getEnemyList());
        }
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (action == WindowInterface.KEY.RIGHT) nextPosition();
        if (action == WindowInterface.KEY.LEFT) lastPosition();
        if (action == WindowInterface.KEY.SELECT){
            if (action == WindowInterface.KEY.RIGHT) nextTPosition();
            if (action == WindowInterface.KEY.LEFT) lastTPosition();
            if (action == WindowInterface.KEY.SELECT){
                if(currentTPositionIndex==0){
                    ArcherTower s= new ArcherTower(availablePositions.get(currentPositionIndex).getX(),availablePositions.get(currentPositionIndex).getX());
                    //addTowers(s);
                }
                if(currentTPositionIndex==1){

                }
                if(currentTPositionIndex==2){

                }
            }
        }
    }
}
