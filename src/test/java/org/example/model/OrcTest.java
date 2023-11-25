package org.example.model;

import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrcTest {

    @Test
    public void testHurt() {
        Orc orc = new Orc(1,1);
        orc.hurt(10);
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
        orc.setX(30);
        assertEquals(30, orc.getX());
    }

    @Test
    public void testSetY() {
        Orc orc = new Orc(1,1);
        orc.setY(40);
        assertEquals(40, orc.getY());
    }
}

