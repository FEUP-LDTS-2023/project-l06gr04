package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LevelControllerTest {

    @Mock
    private Arena arena;

    @Mock
    private Game game;

    @Mock
    private WindowInterface.KEY action;

    @Mock
    private Level level;

    @Mock
    private Score score;

    private LevelController levelController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        game = mock(Game.class);
        action = mock(WindowInterface.KEY.class);
        level = mock(Level.class);
        score = mock(Score.class);
        levelController = new LevelController(arena, level);

        //when(arena.getScoreController()).thenReturn(scoreController);
    }

    @Test
    void testConstructor() {
        assertEquals(level, levelController.getLevel());
    }

    @Test
    void testGetLevel() {
        assertEquals(level.getLevel(), levelController.getLevel());
    }

    @Test
    void testStep() throws IOException {
        //when(arena.getModel()).thenReturn(scoreController);

        levelController.step(game, action, System.currentTimeMillis());

        verify(level, times(1)).updateLevel(score);
    }
}
