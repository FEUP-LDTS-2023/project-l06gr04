package org.example.model;

import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.CanonTower;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class CanonTowerTest {

    @Test
    public void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        CanonTower canonTower = new CanonTower(1,1);
        if(canonTower.isInRange(enemy)) {
            canonTower.attack(enemy);
        }
        verify(enemy).hurt(canonTower.dealDamage());
    }

    @Test
    public void testDealDamage() {
        CanonTower canonTower = new CanonTower(1,1);
        int damage = canonTower.dealDamage();
        assertEquals(6, damage);
    }

    @Test
    public void testUpgrade() {
        CanonTower canonTower = new CanonTower(1,1);

        canonTower.upgrade();
        assertEquals(2, canonTower.getLevel());
        assertEquals(3, canonTower.getRange());
        assertEquals(400, canonTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.upgrade();
        canonTower.upgrade();
        canonTower.upgrade();
        assertEquals(4, canonTower.getLevel());
        assertEquals(5, canonTower.getRange());
        assertEquals(600, canonTower.getLife());
    }
    @Test
    public void testGetX() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals(1, canonTower.getX());
    }

    @Test
    public void testGetY() {
        CanonTower canonTower = new CanonTower(1,1);
        assertEquals(1, canonTower.getY());
    }

    @Test
    public void testSetX() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.setX(30);
        assertEquals(30, canonTower.getX());
    }

    @Test
    public void testSetY() {
        CanonTower canonTower = new CanonTower(1,1);
        canonTower.setY(40);
        assertEquals(40, canonTower.getY());
    }
}
