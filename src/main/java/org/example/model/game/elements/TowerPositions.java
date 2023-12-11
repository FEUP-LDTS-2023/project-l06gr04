package org.example.model.game.elements;

import org.example.model.game.elements.Element;

public class TowerPositions extends Element {
    private char c;
    public TowerPositions(int x, int y,char c) {
        super(x, y);
        this.c=c;
    }
    public char getSymbol(){
        return this.c;
    }
}

