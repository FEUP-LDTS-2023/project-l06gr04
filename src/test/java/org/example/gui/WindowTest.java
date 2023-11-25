package org.example.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

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
    void drawIntoGameText() throws Exception{
        window.drawIntoGameText(new Position(1,1), "Hello World", "#336699");
        verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }
    @Test
    void testDrawEnemy() throws Exception {
        window.drawEnemy(new Position(1, 1), 'E');
        verify(tg).setForegroundColor(TextColor.Factory.fromString("RED"));
        verify(tg).putString(1, 1, String.valueOf('E'));
    }
    @Test
    void testDrawTower() throws Exception{
        window.drawTower(new Position(1, 1), 'T');
        verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, Mockito.times(1)).putString(1, 1, "T");
    }


    @Test
    void testDrawWall() throws Exception {
        window.drawWall(new Position(3, 3));
        verify(tg).setForegroundColor(TextColor.Factory.fromString("WHITE"));
        verify(tg).putString(3, 3, "#");
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
        verify(tg).putString(5, 5, String.valueOf('C'));
    }


}
