package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Skeleton extends Enemy{
    public Skeleton(){
        super(4,100);
    }
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.putString(new TerminalPosition(2, 5), "S");
    }
}
