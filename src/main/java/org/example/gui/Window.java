package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.io.IOException;

public class Window implements WindowInterface {
    private final Screen screen;
    public Window(Screen screen){
        this.screen=screen;
    }

    public Window() {
        try {
            TerminalSize terminalSize = new TerminalSize(120, 50);
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

//    public void draw() throws IOException {
//        clear();
//        LoadArenaBuilder arenaBuilder = new LoadArenaBuilder(0);
//        Arena arena = arenaBuilder.createArena();
//        List<EnemyViewer> enemyViews = arenaBuilder.createEnemyViews(arena);
//        for (EnemyViewer enemyView : enemyViews) {
//            drawEnemy(enemyView.getEnemy().getPosition(), enemyView.getEnemySymbol());
//            refresh();
//        }
//        List<TowerViewer> towerViews = arenaBuilder.createTowerViews(arena);
//        for(TowerViewer towerView : towerViews){
//            drawTower(towerView.getTower().getPosition(),towerView.getTowerSymbol() );
//            refresh();
//        }
//        List
//    }
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
    public void drawText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }


    @Override
    public void drawTower(Position position, Tower tower){
        drawIntoGameChar(position.getX(), position.getY(), tower.getTowerSymbol(), "GREEN");
    }

    @Override
    public void drawEnemy(Position position, Enemy enemy) {
        drawIntoGameChar(position.getX(), position.getY(), enemy.getEnemySymbol(), "RED");
    }
    @Override
    public void drawScore(String score) {
        drawIntoGameString(0, 0, score, "PURPLE");
    }

    public void drawLevel(String level) {
        drawIntoGameString(20, 0, level, "CYAN");
    }
    @Override
    public void drawWall(Position position) {
        int x = position.getX();
        int y = position.getY();

        TextCharacter wallCharacter = TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE);


        screen.setCharacter(x, y, wallCharacter);

    }

    void drawIntoGameChar(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, "" + c, SGR.BOLD);
    }
    void drawIntoGameString(int x, int y, String c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        for (int i = 0; i < c.length(); i++) {
            tg.putString(x, y, "" + c.charAt(i));
        }
    }
    @Override
    public void drawIntoGameText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
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
    public void drawPath(Position position) {
        drawIntoGameChar(position.getX(), position.getY(), ' ', "WHITE");
    }
}