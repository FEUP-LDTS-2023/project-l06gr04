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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class WindowTest {
    private Window window;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        window = new Window(screen);
    }
    @Test
    void drawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(1, 1), "Hello World", "#336699");
        Mockito.verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(tg, times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void testDrawEnemy() throws Exception {
        Enemy enemy = Mockito.mock(Enemy.class);
        when(enemy.getEnemySymbol()).thenReturn('E');
        window.drawEnemy(new Position(1, 1), enemy);
        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("RED"));
        Mockito.verify(tg).putString(1, 1, "E");
    }

    @Test
    void testDrawTower() throws Exception {
        Tower tower = Mockito.mock(Tower.class);
        when(tower.getTowerSymbol()).thenReturn('T');
        window.drawTower(new Position(1, 1), tower);
        Mockito.verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        Mockito.verify(tg, times(1)).putString(1, 1, "T");
    }

    @Test
    void testDrawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(4, 4), "TEXT", "BLUE");
        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("BLUE"));
        Mockito.verify(tg).putString(4, 4, "TEXT");
    }
    @Test
    void drawTextTest() {
        Position position = new Position(1, 1);
        window.drawText(position, "Test Text", "GREEN");
        Mockito.verify(tg).putString(1, 1, "Test Text", SGR.BOLD);
    }
    @Test
    void testDrawIntoGameChar() throws Exception {
        window.drawIntoGameChar(5, 5, 'C', "YELLOW");
        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        Mockito.verify(tg).putString(5, 5, "C");
    }
}