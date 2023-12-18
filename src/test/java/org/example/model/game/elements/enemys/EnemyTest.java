package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    @Test
    public void testEnemyInitialization() {
        double speed = 1.0;
        int totHP = 300;
        int x = 3;
        int y = 4;

        Orc orc = new Orc(x, y);

        assertEquals(x, orc.getPosition().getX());
        assertEquals(y, orc.getPosition().getY());
        assertEquals(speed, orc.getSpeed());
        assertEquals(totHP, orc.getActHP());
        assertEquals(totHP, orc.getActHP());
        assertEquals(totHP, orc.getHiddenHealth());
    }

    @Test
    public void testHurtEnemy() {
        int x = 3;
        int y = 4;
        int damage = 30;
        Orc orc = new Orc(x, y);

        orc.hurt(damage);

        assertEquals(270, orc.getActHP());
    }

    @Test
    public void testEnemyDie() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getActHP()).thenReturn(0);
        enemy.die();
        assertTrue(enemy.isDead());
        assertEquals(0, enemy.getActHP());
    }
    @Test
    public void testEnemyDieWithNegativeHealth() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getActHP()).thenReturn(0);
        enemy.die();
        enemy.setDeathPosition(enemy.getPosition());
        assertTrue(enemy.isDead());
        assertEquals(0, enemy.getActHP());
    }
    @Test
    public void testMoveSkeleton() {
        Skeleton skeleton = new Skeleton(1,1);
        Position originalPosition = new Position(1,8);
        skeleton.moveEnemies(skeleton);
        assertFalse(originalPosition.equals(skeleton.getPosition()));
    }

    @Test
    public void testMoveGolem() {
        Golem golem = new Golem(1,1);
        Position originalPosition = new Position(1,7);

        golem.moveEnemies(golem);
        assertFalse(originalPosition.equals(golem.getPosition()));
    }

    @Test
    public void testMoveOrc() {
        Orc orc = new Orc(1,1);
        Position originalPosition = new Position(1,6);
        orc.moveEnemies(orc);
        assertFalse(originalPosition.equals(orc.getPosition()));
    }
}
