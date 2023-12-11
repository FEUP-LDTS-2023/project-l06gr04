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
    private WaveController waveController;
    public ArrayList<Enemy> enemies ;
    public ArrayList<Enemy> enimigos;
    private long lastMovement;
    private Arena arena;

    public EnemyController(Arena arena) {
        super(arena);
        this.arena= arena;
        this.waveController = new WaveController(500, 3);
        System.out.println("sdads");
        this.enemies = waveController.getCurrentWave().getEnemyList();
        this.lastMovement = 0;

    }
    /* dar as enemies ao step e ele ir gerando as waves de acordo com o tempo
    * retornar quando enemies for vazia // wave acabou
    * começar nova wave e repetir*/


    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            moveEnemies();

            if (enemies.isEmpty()) {
                System.out.println("Sem inimigos");
                waveController.update();
                enemies.addAll(waveController.getCurrentWave().getEnemyList());
                arena.setEnemies(enemies);
            }

            this.lastMovement = time;
        }
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.moveEnemies(enemy);

        }
    }
}
