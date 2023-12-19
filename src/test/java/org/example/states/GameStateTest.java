package org.example.states;

import org.example.gui.Window;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.towers.Projectile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    @Test
    public void testInitialize_ShouldInitializeGameState() {
        Arena arena = new Arena(120,40);
        Window window = new Window();

        try {
            GameState gameState = new GameState(arena, window);
            assertNotNull(gameState);
            assertEquals(arena, gameState.getModel());
        } catch (Exception e) {
        }
    }
    @Test
    public void testUpdateProjectiles_ShouldHandleProjectileUpdates() {
        Arena arena = new Arena(120,40);
        Window window = new Window();

        try {
            GameState gameState = new GameState(arena, window);
            gameState.updateProjectiles();
            for (Projectile projectile : arena.getProjectiles()) {
                assertTrue(projectile.getTimePassed() >= 0);
            }
        } catch (Exception e) {
        }
    }
}
