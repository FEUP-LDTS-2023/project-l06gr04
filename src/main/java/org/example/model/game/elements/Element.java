package org.example.model.game.elements;

import org.example.model.game.Position;

public class Element {
    private Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    public void setX(int x){
        position.setX(x);
    }
    public void setY(int y){
        position.setY(y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
