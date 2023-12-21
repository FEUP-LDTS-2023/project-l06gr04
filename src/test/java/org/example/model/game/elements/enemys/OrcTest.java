package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Orc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrcTest {
    @Test
    public void testOrcPlacement() {
        Orc orc = new Orc(1,1);
        orc.setPosition(new Position(30,1));
        assertEquals(30, orc.getX());
        assertEquals(1, orc.getY());
    }
    @Test
    public void testOrcSpeed() {
        Orc orc = new Orc(1,1);
        assertEquals(2.0, orc.getSpeed());
    }
    @Test
    public void testOrcActHP() {
        Orc orc = new Orc(1,1);
        assertEquals(300, orc.getActHP());
    }
    @Test 
    public void testHiddenHealth() {
        Orc orc = new Orc(1,1);
        assertEquals(300, orc.getHiddenHealth());
    }
    @Test
    public void testIsDead() {
        Orc orc = new Orc(1,1);
        assertEquals(false, orc.isDead());
        orc.die();
        assertEquals(true, orc.isDead());
    }

    @Test
    public void testHurt() {
        Orc orc = new Orc(1,1);
        orc.damage(10);
        assertEquals(290, orc.getActHP());
    }
    @Test
    public void testGetX() {
        Orc orc = new Orc(1,1);
        assertEquals(1, orc.getX());
    }

    @Test
    public void testGetY() {
        Orc orc = new Orc(1,1);
        assertEquals(1, orc.getY());
    }

    @Test
    public void testSetX() {
        Orc orc = new Orc(1,1);
        orc.setPosition(new Position(30,1));
        assertEquals(30, orc.getX());
    }

    @Test
    public void testSetY() {
        Orc orc = new Orc(1,1);
        orc.setPosition(new Position(1,40));
        assertEquals(40, orc.getY());
    }
}

