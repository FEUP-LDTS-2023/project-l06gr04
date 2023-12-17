package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WindowTest {
    private Screen screen;
    private Window window;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        window = new Window(screen);
    }

    @Test
    void drawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(1, 1), "Hello World", "#336699");
        verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
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
        verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, Mockito.times(1)).putString(1, 1, "T");
    }

    @Test
    void testDrawWall() throws Exception {
        Position position = new Position(3, 3);
        window.drawWall(position);
        verify(tg).setForegroundColor(TextColor.Factory.fromString("WHITE"));
        verify(tg).putString(3, 3, "#", SGR.BOLD);
    }
    @Test
    void testDrawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(4, 4), "TEXT", "BLUE");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("BLUE"));
        verify(tg).putString(4, 4, "TEXT");
    }

    @Test
    void testDrawIntoGameChar() throws Exception {
        window.drawIntoGameChar(5, 5, 'C', "YELLOW");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        verify(tg).putString(5, 5, "C");
    }
}