package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Orc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyControllerTest {

    private Arena mockArena;
    private Score mockScore;
    private LevelController mockLevelController;
    private Game mockGame;

    private EnemyController enemyController;

    @BeforeEach
    void setUp(){
        mockArena = new Arena(120, 40);
        mockScore = new Score();
        mockGame = mock(Game.class);
        mockArena.setScore(mockScore);
        mockLevelController = new LevelController(mockArena, mockArena.getLevel());
        enemyController = new EnemyController(mockArena);
    }

    @Test
    void testStepAndMoveEnemies() throws IOException {
        long initialScoreValue = mockScore.getScore();
        long initialCoinsValue = mockArena.getCoins();

        assertTrue(enemyController.enemies.isEmpty());
        enemyController.step(mockGame, WindowInterface.KEY.UP, 100L);

        assertEquals(0, enemyController.enemies.size());
        assertEquals(initialScoreValue, mockScore.getScore());
        assertEquals(initialCoinsValue, mockArena.getCoins());
    }
    @Test
    void testLevelUpdate() throws IOException {
        long initialScoreValue = mockScore.getScore();
        long initialCoinsValue = mockArena.getCoins();

        assertTrue(enemyController.enemies.isEmpty());
        enemyController.step(mockGame, WindowInterface.KEY.UP, 500);

        assertEquals(0, enemyController.enemies.size());
        assertEquals(initialScoreValue, mockScore.getScore());
        assertEquals(initialCoinsValue, mockArena.getCoins());
    }
    @Test
    void testStepAndMoveEnemiesWithEnemies() throws IOException {
        Orc orc = new Orc(1,6);
        Enemy spyEnemy = spy(orc);
        enemyController.enemies.add(spyEnemy);

        enemyController.step(mockGame, null, 501);
        verify(spyEnemy).moveEnemies(any());

    }

}
