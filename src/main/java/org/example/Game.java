package org.example;

import org.example.controller.game.EnemyController;
import org.example.gui.Window;
import org.example.model.game.Level;
import org.example.model.game.Score;
import org.example.model.game.elements.TowerPositions;
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.example.states.State;
//import org.example.states.TowerPositionsState;
import org.example.viewer.game.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final Window window;
    private State state;
    private Score score;
    private Level level;
    public void setState(State state) {
        this.state = state;
    }


    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.window = new Window();
        this.state = new MenuState(new Menu(), window);
        this.score = new Score();
        this.level = new Level();
    }
    public Window getWindow() {
        return window;
    }

    public static void main(String[] args) throws Exception {
        new Game().start();
    }

    private void start() throws Exception {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, window, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }
            catch (InterruptedException e) {
            }
        }
        window.close();
    }
}