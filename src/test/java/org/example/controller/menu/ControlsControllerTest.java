package org.example.controller.menu;
import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.menu.Controls;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ControlsControllerTest {

    private ControlsController controlsController;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        Controls controls = new Controls();
        controlsController = new ControlsController(controls);
        mockGame = mock(Game.class);
        WindowInterface mockWindow = mock(Window.class);
        when(mockGame.getWindow()).thenReturn((Window) mockWindow);
    }

    @Test
    void testQuitAction() throws Exception {
        WindowInterface.KEY quitKey = WindowInterface.KEY.QUIT;
        controlsController.step(mockGame, quitKey, System.currentTimeMillis());
        verify(mockGame).setState(any(MenuState.class));
    }

    @Test
    void testNonQuitAction() throws Exception {
        WindowInterface.KEY nonQuitKey = WindowInterface.KEY.A;
        controlsController.step(mockGame, nonQuitKey, System.currentTimeMillis());
        verify(mockGame, never()).setState(any(MenuState.class));
    }

}
