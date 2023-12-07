package org.example.gui;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;


    void drawText(Position position, String text, String color);


    void drawIntoGameText(Position position, String text, String color);

    void drawPath(Position position);

    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    void drawTower(Position position, Tower tower);

    void drawEnemy(Position position, Enemy enemy);

    void drawScore(String score);

    void drawWall(Position position);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
