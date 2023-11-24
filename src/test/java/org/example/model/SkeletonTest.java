package org.example.model;

import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkeletonTest {
    @Test
    public void testHurt() {
        Skeleton skel = new Skeleton();
        skel.hurt(50);
        assertEquals(50, skel.getActHP());
    }
    @Test
    public void testGetX() {
        Skeleton skel = new Skeleton();
        assertEquals(1, skel.getX());
    }

    @Test
    public void testGetY() {
        Skeleton skel = new Skeleton();
        assertEquals(1, skel.getY());
    }

    @Test
    public void testSetX() {
        Skeleton skel = new Skeleton();
        skel.setX(30);
        assertEquals(30, skel.getX());
    }

    @Test
    public void testSetY() {
        Skeleton skel = new Skeleton();
        skel.setY(40);
        assertEquals(40, skel.getY());
    }
}
