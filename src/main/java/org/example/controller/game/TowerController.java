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
    private List<Integer> availableTowers;
    private List<Tower> towerList;
    WaveController waveController;
    //temos de adicionar as torres à lista assim que as criamos para que elas possam ser dadas ao draw
    public TowerController(Arena arena) {
        super(arena);
        availableTowers=new ArrayList<>(List.of(1,2,3));
        availablePositions = new ArrayList<>(List.of(new Position(3,19),new Position(14,20),new Position(14,20),new Position(26,24),new Position(34,15),new Position(37,67),new Position(29,85)));
        //WaveController waveController= new WaveController(500, 50);
    }


    public void placeTower(Position position){

    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        switch (action) {
            case NUM_1:
                placeTower(new Position(3,22));
            case NUM_2:
                placeTower(new Position(12,35));
            case NUM_3:
                placeTower(new Position(26,35));
            case NUM_4:
                placeTower(new Position(33,15));
            case NUM_5:
                placeTower(new Position(37,62));
            case NUM_6:
                placeTower(new Position(29,84));
            case NUM_7:
                placeTower(new Position(19,102));
            case NUM_8:
                placeTower(new Position(7,85));
            case NUM_9:
                placeTower(new Position(7,101));
            case C:
            case A:
            case M:
        }
    }
}
