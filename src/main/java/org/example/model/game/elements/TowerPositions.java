package org.example.model.game.elements;


public class TowerPositions extends Element {
    private final char c;
    public TowerPositions(int x, int y,char c) {
        super(x, y);
        this.c=c;
    }
    public char getSymbol(){
        return this.c;
    }
}

