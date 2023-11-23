package org.example.model;

import org.example.model.game.elements.towers.Projectile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectileTest {
    @Test
    public void testMove() {
        Projectile projectile = new Projectile(0, 0, 1, 2, 10);

        projectile.move();

        assertEquals(1.0, projectile.getPos_x(), 0.001);
        assertEquals(2.0, projectile.getPos_y(), 0.001);
    }

    @Test
    public void testSetPos() {
        Projectile projectile = new Projectile(0, 0, 1, 2, 10);

        projectile.setPos(5, 10);

        assertEquals(5.0, projectile.getPos_x(), 0.001);
        assertEquals(10.0, projectile.getPos_y(), 0.001);
    }

    @Test
    public void testIsActive() {
        Projectile activeProjectile = new Projectile(0, 0, 1, 1, 10);
        Projectile inactiveProjectile = new Projectile(0, 0, 1, 1, 10);
        inactiveProjectile.setActive(false);

        assertTrue(activeProjectile.isActive());
        assertFalse(inactiveProjectile.isActive());
    }

    @Test
    public void testGetDmg() {
        Projectile projectile = new Projectile(0, 0, 1, 1, 15);

        assertEquals(15, projectile.getDmg());
    }

    @Test
    public void testSetActive() {
        Projectile projectile = new Projectile(0, 0, 1, 1, 10);

        projectile.setActive(false);

        assertFalse(projectile.isActive());
    }
}
