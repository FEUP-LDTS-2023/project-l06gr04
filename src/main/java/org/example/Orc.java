package org.example;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Orc extends Enemy {
    public Orc(){
        super(2,300);
    }
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.putString(new TerminalPosition(1, 5), "O");
    }
}
