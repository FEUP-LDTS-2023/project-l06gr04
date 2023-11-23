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
}
