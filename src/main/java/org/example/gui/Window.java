package org.example.gui;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.model.game.Point;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.io.IOException;

import static java.awt.Color.RED;

public class Window implements WindowInterface {
    private static final int FPS = 30;
    private static final long FRAME_TIME = 1000 / FPS;
    private long lastFrameTime;
    private long elapsedTime;
    private Screen screen;
    private Arena arena;

    public Window(Screen newScreen) {
        screen = newScreen;
    }
    public Window(Arena arena){
        this.arena = arena;
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
    public void drawArena(Arena arena) {
        for (Wall wall : arena.getWalls()) {
            drawWall(wall.getPosition());
        }
        for (Tower tower : arena.getTowers()) {
            drawTower(tower.getPosition());
        }
        for (Enemy enemy : arena.getEnemies()) {
            drawEnemy(enemy.getPosition());
        }
    }

    private void draw() throws IOException {
        screen.clear();
        drawArena(arena);
        screen.refresh();
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

    @Override
    public KEY processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return KEY.NONE;

        if (key.getKeyType() == KeyType.EOF) return KEY.QUIT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return KEY.QUIT;

        if (key.getKeyType() == KeyType.ArrowUp) return KEY.UP;
        if (key.getKeyType() == KeyType.ArrowRight) return KEY.RIGHT;
        if (key.getKeyType() == KeyType.ArrowDown) return KEY.DOWN;
        if (key.getKeyType() == KeyType.ArrowLeft) return KEY.LEFT;

        if (key.getKeyType() == KeyType.Enter) return KEY.SELECT;

        return KEY.NONE;

    }

    @Override
    public void drawWall(Point position) {
        drawIntoGame(position.getX(), position.getY(), '#', "WHITE");
    }
    @Override
    public void drawTower(Point position) {
        drawIntoGame(position.getX(), position.getY(), 'T', "GREEN");
    }
    @Override
    public void drawEnemy(Point position) {
        drawIntoGame(position.getX(), position.getY(), 'E', "RED");
    }
    private void drawIntoGame(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    public void run() throws IOException {
        long lastFrameTime = System.currentTimeMillis();
        long elapsedTime;

        while (true) {
            long currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastFrameTime;

            if (elapsedTime >= FRAME_TIME) {
                draw();
                KeyStroke keyStroke = screen.pollInput();
                if (keyStroke != null) {
                    if (keyStroke.getKeyType() == KeyType.EOF || (keyStroke.getCharacter() != null && keyStroke.getCharacter() == 'q')) {
                        break;
                    }
                }
                lastFrameTime = currentTime;
            }
        }
    }
}
