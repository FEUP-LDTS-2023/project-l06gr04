package org.example.viewer.menu;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Gameover;
import org.example.viewer.*;
public class GameoverViewer extends Viewer<Gameover> {


    public GameoverViewer(Gameover gameover) {
        super(gameover);
    }

    @Override
    public void drawElements(Window window) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            window.drawText(new Position(20,18  + i), getModel().getTitle(i), "RED");
        window.drawText(new Position(45, 29 ), getModel().getEntry(), "#FFFFFF" );
    }
}
