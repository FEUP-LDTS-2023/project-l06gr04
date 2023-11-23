package org.example.model;

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
}
