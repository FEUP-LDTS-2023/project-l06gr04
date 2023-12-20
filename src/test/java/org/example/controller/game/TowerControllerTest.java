package org.example.controller.game;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.Game;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.MageTower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TowerControllerTest {

    private Arena arena;
    private TowerController towerController;
    private TextGraphics tg;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        mockGame = mock(Game.class);
        towerController = new TowerController(arena);
    }

    @Test
    void testTowerInitialization() {
        assertNotNull(towerController.getTowerList());
        assertTrue(towerController.getTowerList().isEmpty());
    }

    @Test
    void testTowerCreation() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_1;
        long time = System.currentTimeMillis();

        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.A;
        towerController.step(mockGame, action, time);
        towerController.getTowerList().add(new ArcherTower(21, 2));
        assertEquals(1, towerController.getTowerList().size());
        assertTrue(towerController.getTowerList().get(0) instanceof ArcherTower);
        assertEquals(new Position(21, 2), towerController.getTowerList().get(0).getPosition());
    }

    @Test
    void testTowerUpgrade() throws Exception {
        WindowInterface.KEY action = WindowInterface.KEY.NUM_3;
        long time = System.currentTimeMillis();
        towerController.getTowerList().add(new MageTower(34, 25));
        towerController.step(mockGame, action, time);

        action = WindowInterface.KEY.U;
        towerController.step(mockGame, action, time);

        assertEquals(1, towerController.getTowerList().size());

        action = WindowInterface.KEY.U;
        towerController.step(mockGame, action, time);

        assertEquals(1, towerController.getTowerList().size());
        assertEquals(1, towerController.getTowerList().get(0).getLevel());
    }
}

