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
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Projectile;
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
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'm') return KEY.M;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'c') return KEY.C;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a') return KEY.A;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'u') return KEY.U;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return KEY.UP;
        //if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '1') return KEY.NUM_1;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return KEY.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return KEY.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return KEY.LEFT;
        char numericChar = keyStroke.getCharacter();
        if (Character.isDigit(numericChar) && numericChar >= '1' && numericChar <= '9') {
            int numericValue = Character.getNumericValue(numericChar);
            return KEY.fromNumericValue(numericValue);
        }
        if (keyStroke.getKeyType() == KeyType.Enter) return KEY.SELECT;

        return KEY.NONE;
    }
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));

        // Use SGR.BOLD para aumentar o tamanho da letra
        tg.putString(position.getX(), position.getY(), text, SGR.BOLD);
    }
    public void drawTextWithFontSize( Position position, String text, String color, int fontSize) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));

        for (int i = 0; i < text.length(); i++) {
            tg.setCharacter(position.getX() + i * fontSize, position.getY(),
                    new TextCharacter(text.charAt(i), TextColor.Factory.fromString(color), TextColor.ANSI.DEFAULT));
        }
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
        drawIntoGameString(21, 0, score, "WHITE");
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
        tg.putString(x, y, "" + c);
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
        int x = position.getX();
        int y = position.getY();

        TextCharacter wallCharacter = TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE);


        screen.setCharacter(x, y, wallCharacter);
    }

    public void drawChest(Position position, Chest chest) {
        drawIntoGameChar(position.getX(), position.getY(), chest.getChestSymbol(), "YELLOW");
    }
    public void drawTowerPositions(Position position, TowerPositions towerPositions) {
        drawIntoGameChar(position.getX(), position.getY(), towerPositions.getSymbol(), "GREEN");
    }
    public void drawProjectiles(Position position, Window window){
        drawIntoGameChar(position.getX(), position.getY(), '.', "RED");
    }
}