package org.example.model.game.elements.enemys;
import org.example.model.game.elements.enemys.Enemy;

public class Orc extends Enemy {
    private static final double ORC_SPEED = 2;
    private static final int ORC_TOT_HP = 300;

    public Orc(int x, int y){
        super(ORC_SPEED,ORC_TOT_HP,x,y);
    }
}
