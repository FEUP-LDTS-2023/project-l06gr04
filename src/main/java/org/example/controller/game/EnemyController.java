package org.example.controller.game;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.Wave;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.controller.Clock;
import org.example.model.game.elements.enemys.Orc;
import org.example.viewer.game.GameViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {
    public ArrayList<Enemy> enemies ;
    public ArrayList<Enemy> enimigos;
    private long lastMovement;
    public EnemyController(Arena arena) {
        super(arena);
        //Wave wave= new Wave(500, 3);
        //this.enemies=wave.getEnemyList();
        //enemies=wave.getEnemyList();
        WaveController waveController= new WaveController(500, 3);
        this.enemies = waveController.getCurrentWave().getEnemyList();
        arena.setEnemies(enemies);
        this.lastMovement=0;
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            this.lastMovement = time;
        }
    }
}
