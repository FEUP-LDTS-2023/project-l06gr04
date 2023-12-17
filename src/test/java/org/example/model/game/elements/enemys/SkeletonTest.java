package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Skeleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkeletonTest {
    @Test
    public void testHurt() {
        Skeleton skel = new Skeleton(1,1);
        skel.hurt(50);
        assertEquals(50, skel.getActHP());
    }
    @Test
    public void testGetX() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(1, skel.getX());
    }

    @Test
    public void testGetY() {
        Skeleton skel = new Skeleton(1,1);
        assertEquals(1, skel.getY());
    }

    @Test
    public void testSetX() {
        Skeleton skel = new Skeleton(1,1);
        skel.setPosition(new Position(30,1));
        assertEquals(30, skel.getX());
    }

    @Test
    public void testSetY() {
        Skeleton skel = new Skeleton(1,1);
        skel.setPosition(new Position(1,40));
        assertEquals(40, skel.getY());
    }
}
