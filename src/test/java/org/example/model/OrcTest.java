package org.example.model;

import org.example.model.game.elements.enemys.Golem;
import org.example.model.game.elements.enemys.Orc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrcTest {

    @Test
    public void testHurt() {
        Orc orc = new Orc();
        orc.hurt(10);
        assertEquals(290, orc.getActHP());
    }
    @Test
    public void testGetX() {
        Orc orc = new Orc();
        assertEquals(1, orc.getX());
    }

    @Test
    public void testGetY() {
        Orc orc = new Orc();
        assertEquals(1, orc.getX());
    }

    @Test
    public void testSetX() {
        Orc orc = new Orc();
        orc.setX(30);
        assertEquals(30, orc.getX());
    }

    @Test
    public void testSetY() {
        Orc orc = new Orc();
        orc.setY(40);
        assertEquals(40, orc.getY());
    }
}

