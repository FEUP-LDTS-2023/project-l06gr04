package org.example.model;

import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.model.game.elements.towers.ArcherTower;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ArcherTowerTest {
    @Test
    public void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        ArcherTower archerTower = new ArcherTower();
        if(archerTower.isInRange(enemy)) {
            archerTower.attack(enemy);
        }
        verify(enemy).hurt(archerTower.dealDamage());
    }


    @Test
    public void testDealDamage() {
        ArcherTower archerTower = new ArcherTower();
        int damage = archerTower.dealDamage();
        assertEquals(5 + archerTower.getLevel() * 5, damage);
    }

    @Test
    public void testUpgrade() {
        ArcherTower archerTower = new ArcherTower();
        archerTower.upgrade();
        assertEquals(2, archerTower.getLevel());
        assertEquals(5, archerTower.getRange());
        assertEquals(300, archerTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        ArcherTower archerTower = new ArcherTower();
        archerTower.upgrade();
        archerTower.upgrade();
        archerTower.upgrade();
        assertEquals(4, archerTower.getLevel());
        assertEquals(9, archerTower.getRange());
        assertEquals(400, archerTower.getLife());
    }
    @Test
    public void testGetX() {
        ArcherTower archerTower = new ArcherTower();
        assertEquals(2, archerTower.getX());
    }

    @Test
    public void testGetY() {
        ArcherTower archerTower = new ArcherTower();
        assertEquals(1, archerTower.getY());
    }

    @Test
    public void testSetX() {
        ArcherTower archerTower = new ArcherTower();
        archerTower.setX(30);
        assertEquals(30, archerTower.getX());
    }

    @Test
    public void testSetY() {
        ArcherTower archerTower = new ArcherTower();
        archerTower.setY(40);
        assertEquals(40, archerTower.getY());
    }
}
