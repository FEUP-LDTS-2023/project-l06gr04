package org.example;

import java.util.Objects;

public class Position {
    int weight;
    int height;

    public Position(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int row) {
        this.weight = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return weight == position.weight && height == position.height;
    }
    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }
}
