package org.example.model;

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
}

