package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class EnemyControllerTest {

    private Arena mockArena;
    private Level mockLevel;
    private Score mockScore;
    private Game mockGame;

    private EnemyController enemyController;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        mockArena = new Arena(120,40);
        mockLevel = new Level();
        mockScore = new Score();
        mockGame = mock(Game.class);
        mockArena.setScore(mockScore);

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
        assertEquals(initialCoinsValue , mockArena.getCoins());

    }

}
