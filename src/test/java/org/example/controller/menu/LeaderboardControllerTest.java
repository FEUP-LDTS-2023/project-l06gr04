package org.example.controller.menu;
import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.menu.Leaderboard;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LeaderboardControllerTest {

    private LeaderboardController leaderboardController;
    private Game mockGame;

    @BeforeEach
    void setUp() throws IOException {
        Leaderboard leaderboard = new Leaderboard();
        leaderboardController = new LeaderboardController(leaderboard);
        mockGame = mock(Game.class);
        WindowInterface mockWindow = mock(Window.class);
        when(mockGame.getWindow()).thenReturn((Window) mockWindow);
    }

    @Test
    void testQuitAction() throws Exception {
        WindowInterface.KEY quitKey = WindowInterface.KEY.QUIT;
        leaderboardController.step(mockGame, quitKey, System.currentTimeMillis());
        verify(mockGame).setState(any(MenuState.class));
    }

    @Test
    void testNonQuitAction() throws Exception {
        WindowInterface.KEY nonQuitKey = WindowInterface.KEY.A;
        leaderboardController.step(mockGame, nonQuitKey, System.currentTimeMillis());
        verify(mockGame, never()).setState(any(MenuState.class));
    }

}