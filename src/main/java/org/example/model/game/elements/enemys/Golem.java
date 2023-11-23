package org.example.model.game.elements.enemys;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.game.elements.enemys.Enemy;

public class Golem extends Enemy {
    public Golem(){
        super(1,1000);
    }
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.putString(new TerminalPosition(1, 5), "G");
    }
}
