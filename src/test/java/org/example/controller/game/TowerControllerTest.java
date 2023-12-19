package org.example.controller.game;



import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TowerControllerTest {

    @Mock
    private Arena arena;

    @Mock
    private Game game;

    @Mock
    private WindowInterface.KEY action;

    private TowerController towerController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        game = mock(Game.class);
        action = mock(WindowInterface.KEY.class);
        towerController = new TowerController(arena);

        //when(arena.getModel()).thenReturn(game);
        //when(game.getCoins()).thenReturn(500);
        when(arena.getCoins()).thenReturn(500);
        when(arena.getTowers()).thenReturn(Collections.emptyList());
    }

    @Test
    void testConstructor() {
        assertNotNull(towerController.getTowerList());
        //assertFalse(towerController.isSelected());
        //assertNull(towerController.getSelectedPosition());
    }

    @Test
    void testStep_AddCanonTower() throws Exception {
        when(action).thenReturn(WindowInterface.KEY.C);
        when(action.name()).thenReturn("C");

        towerController.step(game, action, System.currentTimeMillis());

        verify(arena, times(1)).getCoins();
        verify(arena, times(1)).setCoins(anyInt());
        verify(arena, times(1)).addTowers(any(CanonTower.class));
    }

    @Test
    void testStep_AddArcherTower() throws Exception {
        when(action).thenReturn(WindowInterface.KEY.A);
        when(action.name()).thenReturn("A");

        towerController.step(game, action, System.currentTimeMillis());

        verify(arena, times(1)).getCoins();
        verify(arena, times(1)).setCoins(anyInt());
        verify(arena, times(1)).addTowers(any(ArcherTower.class));
    }

    @Test
    void testStep_AddMageTower() throws Exception {
        when(action).thenReturn(WindowInterface.KEY.M);
        when(action.name()).thenReturn("M");

        towerController.step(game, action, System.currentTimeMillis());

        verify(arena, times(1)).getCoins();
        verify(arena, times(1)).setCoins(anyInt());
        verify(arena, times(1)).addTowers(any(MageTower.class));
    }

    @Test
    void testStep_UpgradeTower() throws Exception {
        when(action).thenReturn(WindowInterface.KEY.U);
        when(action.name()).thenReturn("U");
        //towerController.setSelected(true);

        towerController.step(game, action, System.currentTimeMillis());

        verify(arena, times(1)).getCoins();
        verify(arena, times(1)).setCoins(anyInt());
        verify(arena, times(1)).getTowers();
        
    }
}

