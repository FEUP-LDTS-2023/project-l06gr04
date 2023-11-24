package org.example.gui;

import org.example.model.game.Position;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;

    void drawHero(Position position);

    void drawMonster(Position position);

    void drawTower(Position position);

    void drawEnemy(Position position);

    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    void drawWall(Position position);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
