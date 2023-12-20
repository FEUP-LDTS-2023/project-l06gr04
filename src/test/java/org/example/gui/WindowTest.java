package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.example.model.game.Position;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class WindowTest {
    private Window window;
    private TextGraphics tg;
    private ArrayList<TowerPositions> towerPositions;
    @BeforeEach
    void setUp() {
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        window = new Window(screen);
        towerPositions = new ArrayList<>();
        towerPositions.add(new TowerPositions(1, 1, '1'));
    }
    @Test
    void drawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(1, 1), "Hello World", "#336699");
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        verify(tg, times(1)).putString(1, 1, "Hello World");
    }
    @Test
    void drawWall() throws Exception {
        window.drawWall(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE));
    }

    @Test
    void drawPixel() throws Exception {
        window.drawPixel(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.BLUE_BRIGHT));
    }

    @Test
    void testRefresh() throws Exception {
        window.refresh();
        verify(window.getScreen(), times(1)).refresh();
    }

    @Test
    void testDrawChest() throws Exception {
        window.drawChest(new Position(1, 1), new Chest(1, 1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        verify(tg, times(1)).putString(1, 1, "C");
    }

    @Test
    void testDrawPath() throws Exception {
        window.drawPath(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE));
    }

    @Test
    void testDrawTowerPositions() throws Exception {
        window.drawTowerPositions(new Position(1, 1), towerPositions.get(0));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, times(1)).putString(1, 1, "1");
    }
    @Test
    void testDrawEnemy() throws Exception {
        Enemy enemy = Mockito.mock(Enemy.class);
        when(enemy.getEnemySymbol()).thenReturn('E');
        window.drawEnemy(new Position(1, 1), enemy);
        verify(tg).setForegroundColor(TextColor.Factory.fromString("RED"));
        verify(tg).putString(1, 1, "E");
    }

    @Test
    void testDrawTower() throws Exception {
        Tower tower = Mockito.mock(Tower.class);
        when(tower.getTowerSymbol()).thenReturn('T');
        window.drawTower(new Position(1, 1), tower);
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, times(1)).putString(1, 1, "T");
    }

    @Test
    void testDrawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(4, 4), "TEXT", "BLUE");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("BLUE"));
        verify(tg).putString(4, 4, "TEXT");
    }
    @Test
    void drawTextTest() {
        Position position = new Position(1, 1);
        window.drawText(position, "Test Text", "GREEN");
        verify(tg).putString(1, 1, "Test Text", SGR.BOLD);
    }
    @Test
    void testDrawIntoGameChar() throws Exception {
        window.drawIntoGameChar(5, 5, 'C', "YELLOW");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        verify(tg).putString(5, 5, "C");
    }
}