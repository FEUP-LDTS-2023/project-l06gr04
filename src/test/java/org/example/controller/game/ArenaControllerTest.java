package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.arena.Arena;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ArenaControllerTest {

    @Test
    public void testStep() throws Exception {
        Game game = mock(Game.class);
        WindowInterface.KEY action = WindowInterface.KEY.SELECT;
        long time = 100;

        Arena arena = mock(Arena.class);
        when(arena.getLevel()).thenReturn(mock(Level.class));

        ArenaController arenaController = new ArenaController(arena);

        arenaController.step(game, action, time);

        verify(arena, times(1)).getLevel();
        verify(arena, times(1)).getTowers();
        verify(arena, times(1)).getCoins();
    }
}