package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoadArenaBuilder;
import org.example.viewer.game.EnemyViewer;
import org.example.viewer.game.TowerViewer;
import org.example.viewer.game.WallViewer;

import java.io.IOException;
import java.util.List;

public class Window implements WindowInterface {
    private final Screen screen;

    public Window() {
        try {
            TerminalSize terminalSize = new TerminalSize(120, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao iniciar a tela", e);
        }
    }

    public void draw() throws IOException {
        clear();
        LoadArenaBuilder arenaBuilder = new LoadArenaBuilder();
        Arena arena = arenaBuilder.createArena();
        List<WallViewer> wallViews = arenaBuilder.createWallViews(arena);
        for (WallViewer wallView : wallViews) {
            drawWall(wallView.getModel().getPosition());
            refresh();
        }
        List<EnemyViewer> enemyViews = arenaBuilder.createEnemyViews(arena);
        for (EnemyViewer enemyView : enemyViews) {
            drawEnemy(enemyView.getEnemy().getPosition(), enemyView.getEnemySymbol());
            refresh();
        }
        List<TowerViewer> towerViews = arenaBuilder.createTowerViews(arena);
        for(TowerViewer towerView : towerViews){
            drawTower(towerView.getTower().getPosition(),towerView.getTowerSymbol() );
            refresh();
        }
    }
    @Override
    public KEY processKey() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return KEY.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return KEY.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return KEY.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return KEY.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return KEY.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return KEY.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return KEY.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return KEY.SELECT;

        return KEY.NONE;
    }


    @Override
    public void drawTower(Position position, Character towerSymbol) {
        drawIntoGame(position.getX(), position.getY(), towerSymbol, "GREEN");
    }

    @Override
    public void drawEnemy(Position position, Character enemySymbol) {
        drawIntoGame(position.getX(), position.getY(), enemySymbol, "RED");
    }

    @Override
    public void drawWall(Position position) {
        drawIntoGame(position.getX(), position.getY(), '#', "WHITE");
    }

    private void drawIntoGame(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}