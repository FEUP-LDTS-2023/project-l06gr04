package org.example.model.game.elements.towers;


public class CanonTower extends Tower{
    private static final int CT_LIFE = 300;
    private static final int LEVEL = 1;
    private static final int RANGE= 2;
    private static final int COST = 100;
    public CanonTower(int x, int y) {
        super(CT_LIFE, LEVEL, RANGE, COST, x, y);
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
