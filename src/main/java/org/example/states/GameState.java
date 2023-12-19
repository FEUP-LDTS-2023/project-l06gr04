package org.example.states;

import org.example.Game;
import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.controller.game.EnemyController;
import org.example.controller.game.ScoreController;
import org.example.controller.game.TowerController;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Score;

import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.Projectile;
import org.example.model.game.elements.towers.Tower;
import org.example.model.menu.Leaderboard;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GameState extends State<Arena> {
    private final EnemyController enemyController;
    private final TowerController towerController;

    private final long TIME_FIXED = 100;
    private final ScoreController scoreController;

    private final Arena arena;
    private long totalTime, pastTime;
    Window window;


    public GameState(Arena arena, Window window) throws Exception {
        super(arena, window);
        this.arena=arena;
        this.window = window;
        enemyController = new EnemyController(arena);
        towerController = new TowerController(arena);
        scoreController = new ScoreController(arena, new Score());
        initialize();
    }

    public void initialize() throws Exception {
        totalTime = 0;
        pastTime = System.currentTimeMillis();
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
    public void update(Game game,WindowInterface.KEY action, Window window) throws Exception {
        enemyController.step(game, null, System.currentTimeMillis());
        scoreController.step(game, null, System.currentTimeMillis());
        towerController.step(game, action, System.currentTimeMillis());
        updateProjectiles();

    }

    @Override
    public void step(Game game, Window window, long time) throws Exception {

        WindowInterface.KEY key = window.processKey();
        if (key==WindowInterface.KEY.QUIT) {
            game.setState(new MenuState(new Menu(),window));
            return;
        }
        if(getModel().getChest().getLife()<=0){
            List<Integer> highScores = new ArrayList<>();
            int novoScore = getModel().getScore().getScore();

            URL resource = Leaderboard.class.getResource("/scores");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
                String linha;
                int contador = 0;
                while ((linha = br.readLine()) != null && contador < 6) {
                    highScores.add(Integer.parseInt(linha.trim()));
                    contador++;
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

            highScores.add(novoScore);

            Collections.sort(highScores, Collections.reverseOrder());

            if (highScores.size() > 6) {
                highScores = highScores.subList(0, 6);
            }

            File tempFile = File.createTempFile("tempScores", ".tmp");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
                for (int score : highScores) {
                    bw.write(Integer.toString(score));
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Files.copy(tempFile.toPath(), Paths.get(resource.toURI()), StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();
            game.setState(new MenuState(new Menu(),window));
        }

        totalTime += getTimePassed();
        while(totalTime >=TIME_FIXED){
            update(game,key,window);
            totalTime -= TIME_FIXED;
        }
        getViewer().draw(window);
    }
    public void updateProjectiles() throws Exception {
        List<Projectile> allProjectiles = new ArrayList<>();
        for (Tower tower : arena.getTowers()) {
            tower.setEnemies(arena.getEnemies());
            allProjectiles.addAll(tower.getProjectiles());
        }
        arena.setProjectiles(allProjectiles);

        for (Projectile projectile : allProjectiles) {
            projectile.update();
        }
        Iterator<Projectile> projectileIterator = allProjectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            if (!projectile.isAlive()) {
                projectileIterator.remove();
            }
        }

    }
    public long getTimePassed() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - pastTime;
        pastTime = currentTime;
        return timePassed;
    }
}