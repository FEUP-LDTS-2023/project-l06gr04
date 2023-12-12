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
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.example.model.game.arena.Arena;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController{
    private List<Tower> towerList;
    private Arena arena;
    private long lastMovement;

    //temos de adicionar as torres à lista assim que as criamos para que elas possam ser dadas ao draw
    public TowerController(Arena arena) {
        super(arena);
        this.arena=arena;
        this.towerList =new ArrayList<>();

    }

    public List<Tower> getTowerList(){
        return towerList;
    }

    public void placeTower(Position position){

    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {

            ArcherTower ArcherTower;
            System.out.println(action);
            switch (action) {
                case NUM_1:
                    System.out.println("111111111111111111");
                    ArcherTower = new ArcherTower(21, 2);

                    arena.addTowers(ArcherTower);
                    break;
                case NUM_2:
                    ArcherTower = new ArcherTower(34,11);
                    arena.addTowers(ArcherTower);
                    break;
                case NUM_3:
                    placeTower(new Position(26,35));
                    break;
                case NUM_4:
                    placeTower(new Position(33,15));
                    break;
                case NUM_5:
                    placeTower(new Position(37,62));
                    break;
                case NUM_6:
                    placeTower(new Position(29,84));
                    break;
                case NUM_7:
                    placeTower(new Position(19,102));
                    break;
                case NUM_8:
                    placeTower(new Position(7,85));
                    break;
                case NUM_9:
                    placeTower(new Position(7,101));
                    break;
                case C:
                    break;
                case A:
                    break;
                case M:
                    break;
                default:
                    break;
            }
    }
}
