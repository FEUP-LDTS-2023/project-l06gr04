package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.*;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyControllerTest {

    @Mock
    private Arena arena;

    @Mock
    private Game game;

    @Mock
    private WindowInterface.KEY action;

    @Mock
    private LevelController levelController;

    @Mock
    private Level level;

    @Mock
    private Wave wave;

    @Mock
    private Score scoreModel;

    @Mock
    private Enemy enemy;

    private EnemyController enemyController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        game = mock(Game.class);
        action = mock(WindowInterface.KEY.class);
        levelController = mock(LevelController.class);
        level = mock(Level.class);
        wave = mock(Wave.class);
        scoreModel = mock(Score.class);
        enemy = mock(Enemy.class);
        enemyController = new EnemyController(arena);

        when(arena.getLevel()).thenReturn(level);
        when(arena.getScore()).thenReturn(scoreModel);
        //when(arena.getLevelController()).thenReturn(levelController);
        //when(arena.getWave()).thenReturn(wave);
        when(wave.getEnemyList()).thenReturn(Collections.singletonList(enemy));
        when(level.getLevel()).thenReturn(1);
        when(arena.getEnemies()).thenReturn(Collections.singletonList(enemy));
    }

    @Test
    void testConstructor() {
        assertNotNull(enemyController.enemies);
        //assertNotNull(enemyController.level);
        //assertNotNull(enemyController.arena);
        //assertNotNull(enemyController.levelController);
        //assertNotNull(enemyController.wave);
        //assertNotNull(enemyController.scoreModel);
    }

    @Test
    void testStep() throws IOException {
        long time = System.currentTimeMillis();
        enemyController.step(game, action, time);
        verify(levelController, times(1)).step(game, action, time);
    }

    @Test
    void testMoveEnemies() {
        Enemy enemyMock = mock(Enemy.class);
        enemyController.enemies = Collections.singletonList(enemyMock);
        enemyController.moveEnemies();
        verify(enemyMock, times(1)).moveEnemies(any());
    }

    @Test
    void testUpdateScore() {
        enemyController.enemies.add(enemy);

        when(enemy.getEnemySymbol()).thenReturn('S');
        when(enemy.deathPosition()).thenReturn(new Position(93, 5));

        enemyController.updateScore(enemy);

        verify(scoreModel, times(1)).incrementScore(10 + level.getLevel() * 2);
        verify(arena, times(1)).setEnemies(anyList());
        //verify(scoreModel, times(1)).setCoins(anyInt());
    }
}
