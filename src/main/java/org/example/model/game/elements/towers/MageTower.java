package org.example.model.game.elements.towers;


public class MageTower extends Tower {
    private static final int MT_LIFE = 100;
    private static final int LEVEL = 1;
    private static final int RANGE= 5;
    private static final int COST = 500;
    public MageTower(int x, int y){
        super(MT_LIFE, LEVEL, RANGE, COST,x,y);

    }


    @Override
    public int dealDamage() {
        return 20 + getLevel() * 5;
    }

    @Override
    public void upgrade() {
        setLevel(getLevel()+1);
        setRange(getRange()+4);
        setLife(getLife() + 25);
    }
}