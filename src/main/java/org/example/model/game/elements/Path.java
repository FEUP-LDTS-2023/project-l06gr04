package org.example.model.game.elements;

import org.example.model.game.Position;

public class Path extends Element {
    private char[][] pathMatrix;

    public Path(int width, int height) {
        super(0, 0);
        this.pathMatrix = new char[width][height];
    }

    public char[][] getPathMatrix() {
        return pathMatrix;
    }

    public void setPathMatrix(char[][] pathMatrix) {
        this.pathMatrix = pathMatrix;
    }

    public void initializePathMatrix(int width, int height) {
        pathMatrix = new char[width][height];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pathMatrix[col][row] = ' ';
            }
        }
    }


    public boolean isPath(Position position) {
        return position.getX() >= 0 && position.getX() < pathMatrix.length &&
                position.getY() >= 0 && position.getY() < pathMatrix[0].length &&
                pathMatrix[position.getX()][position.getY()] == ' ';
    }
}
