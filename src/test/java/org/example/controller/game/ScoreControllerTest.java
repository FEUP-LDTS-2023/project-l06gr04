package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ScoreControllerTest {

    @Mock
    private Arena arena;

    @Mock
    private Game game;

    @Mock
    private WindowInterface.KEY action;

    @Mock
    private Level level;

    @Mock
    private Score scoreModel;

    @Mock
    private Enemy enemy;

    private ScoreController scoreController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        game = mock(Game.class);
        action = mock(WindowInterface.KEY.class);
        level = mock(Level.class);
        scoreModel = mock(Score.class);
        enemy = mock(Enemy.class);
        scoreController = new ScoreController(arena, scoreModel);

        when(arena.getLevel()).thenReturn(level);
        //when(arena.getModel()).thenReturn(game);
        //when(game.getEnemies()).thenReturn(Collections.singletonList(enemy));
    }

    @Test
    void testConstructor() {
        //assertNotNull(scoreController.getScoreModel());
        //assertNotNull(scoreController.getLevel());
        //assertEquals(0, scoreController.getLastMovement());
    }

    @Test
    void testStep() throws IOException {
        long time = System.currentTimeMillis();
        scoreController.step(game, action, time);

        verify(scoreModel, times(1)).incrementScore(anyInt());
        //verify(game, times(1)).setCoins(anyInt());
        verify(level, times(1)).updateLevel(scoreModel);
        //assertEquals(time, scoreController.getLastMovement());
    }

    @Test
    void testUpdateScore() {
        when(enemy.isDead()).thenReturn(true);
        when(enemy.getEnemySymbol()).thenReturn('S');

        scoreController.updateScore();

        verify(scoreModel, times(1)).incrementScore(anyInt());
        //verify(game, times(1)).setCoins(anyInt());
    }
}
