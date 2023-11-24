package org.example.model;

import org.example.model.game.elements.enemys.Golem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GolemTest {
    @Test
    public void testHurt() {
        Golem golem = new Golem();
        golem.hurt(30);
        assertEquals(970, golem.getActHP());
    }
    @Test
    public void testGetX() {
        Golem golem = new Golem();
        assertEquals(1, golem.getX());
    }

    @Test
    public void testGetY() {
        Golem golem = new Golem();
        assertEquals(1, golem.getX());
    }

    @Test
    public void testSetX() {
        Golem golem = new Golem();
        golem.setX(30);
        assertEquals(30, golem.getX());
    }

    @Test
    public void testSetY() {
        Golem golem = new Golem();
        golem.setY(40);
        assertEquals(40, golem.getY());
    }
}
