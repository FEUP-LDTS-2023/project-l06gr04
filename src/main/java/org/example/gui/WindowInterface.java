package org.example.gui;

import org.example.model.game.Point;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;

    void drawHero(Point position);

    void drawMonster(Point position);

    void drawTower(Point position);

    void drawEnemy(Point position);

    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    void drawWall(Point position);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
