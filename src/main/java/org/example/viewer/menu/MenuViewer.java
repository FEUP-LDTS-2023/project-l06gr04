package org.example.viewer.menu;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Menu;
import org.example.viewer.*;
public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(Window window) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            window.drawText(new Position(0,2  + i), getModel().getTitle(i), "WHITE");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            window.drawText(new Position(10, 30 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

