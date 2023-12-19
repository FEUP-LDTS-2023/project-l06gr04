package org.example.controller.menu;

import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.menu.Menu;
import org.example.states.ControlsState;
import org.example.states.GameState;
import org.example.states.LeaderboardState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuControllerTest {

    private MenuController menuController;
    private Game mockGame;
    private WindowInterface mockWindow;

    @BeforeEach
    void setUp() {
        Menu menu = new Menu();
        List<String> entries = Arrays.asList("Start", "HighScore", "Controls", "Exit");

        menuController = new MenuController(menu);
        mockGame = mock(Game.class);
        mockWindow = mock(Window.class);
        when(mockGame.getWindow()).thenReturn((Window) mockWindow);
    }

    @Test
    void testUpAction() throws Exception {
        WindowInterface.KEY upKey = WindowInterface.KEY.UP;

        menuController.step(mockGame, upKey, System.currentTimeMillis());

        verify(mockGame, never()).setState(any());
    }

    @Test
    void testDownAction() throws Exception {
        WindowInterface.KEY downKey = WindowInterface.KEY.DOWN;

        menuController.step(mockGame, downKey, System.currentTimeMillis());

        verify(mockGame, never()).setState(any());
    }

    @Test
    void testSelectStartAction() throws Exception {
        WindowInterface.KEY selectKey = WindowInterface.KEY.SELECT;

        menuController.step(mockGame, selectKey, System.currentTimeMillis());

        verify(mockGame).setState(any(GameState.class));
    }

    @Test
    void testSelectLeaderboardAction() throws Exception {
        WindowInterface.KEY selectKey = WindowInterface.KEY.SELECT;

        menuController.getModel().nextEntry();

        menuController.step(mockGame, selectKey, System.currentTimeMillis());

        verify(mockGame).setState(any(LeaderboardState.class));
    }

    @Test
    void testSelectControlsAction() throws Exception {
        WindowInterface.KEY selectKey = WindowInterface.KEY.SELECT;

        menuController.getModel().nextEntry();
        menuController.getModel().nextEntry();

        menuController.step(mockGame, selectKey, System.currentTimeMillis());

        verify(mockGame).setState(any(ControlsState.class));
    }

    @Test
    void testSelectExitAction() throws Exception {
        WindowInterface.KEY selectKey = WindowInterface.KEY.SELECT;
        menuController.getModel().nextEntry();
        menuController.getModel().nextEntry();
        menuController.getModel().nextEntry();
        menuController.step(mockGame, selectKey, System.currentTimeMillis());
        verify(mockGame).setState(null);
    }
}

