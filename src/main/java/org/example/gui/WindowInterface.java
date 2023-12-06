package org.example.gui;

import org.example.model.game.Position;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;


    void drawTower(Position position, Character towerSymbol);
    void drawText(Position position, String text, String color);
    void drawEnemy(Position position, Character enemySymbol);
    void drawIntoGameText(Position position, String text, String color);
    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    void drawWall(Position position);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
