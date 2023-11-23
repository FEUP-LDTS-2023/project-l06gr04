package org.example.model;

import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.CanonTower;
import org.example.model.game.elements.towers.MageTower;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class MageTowerTest {

    @Test
    public void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        MageTower mageTower = new MageTower();
        if(mageTower.isInRange(enemy)){
            mageTower.attack(enemy);
        }
        verify(enemy).hurt(mageTower.dealDamage());
    }

    @Test
    public void testDealDamage() {
        MageTower mageTower = new MageTower();
        int damage = mageTower.dealDamage();
        assertEquals(25, damage);
    }

    @Test
    public void testUpgrade() {
        MageTower mageTower = new MageTower();

        mageTower.upgrade();
        assertEquals(2, mageTower.getLevel());
        assertEquals(9, mageTower.getRange());
        assertEquals(125, mageTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        MageTower mageTower = new MageTower();
        mageTower.upgrade();
        mageTower.upgrade();
        mageTower.upgrade();
        assertEquals(4, mageTower.getLevel());
        assertEquals(17, mageTower.getRange());
        assertEquals(175, mageTower.getLife());
    }
}
