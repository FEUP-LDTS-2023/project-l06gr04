package org.example.model.game.elements.towers;

import org.example.model.game.elements.enemys.Enemy;

public class CanonTower extends Tower{

    public CanonTower(){
        super(300, 1, 2, 100, 2,1);
    }

    @Override
    public int dealDamage() {
        return 1 + getLevel() * 5;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+1);
        setLife(getLife() +100);
    }
}
