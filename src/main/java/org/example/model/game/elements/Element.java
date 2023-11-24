package org.example.model.game.elements;

import org.example.model.game.Point;

public class Element {
    private Point position;

    public Element(int x, int y) {
        this.position = new Point(x, y);
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
