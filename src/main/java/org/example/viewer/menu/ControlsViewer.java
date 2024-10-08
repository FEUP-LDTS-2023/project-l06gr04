package org.example.viewer.menu;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Controls;
import org.example.viewer.Viewer;


public class ControlsViewer extends Viewer<Controls> {


    public ControlsViewer(Controls controls) {
        super(controls);
    }

    @Override
    public void drawElements(Window window) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            window.drawText(new Position(5,2  + i), getModel().getTitle(i), "WHITE");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            window.drawText(new Position(10, 14 + i*5), getModel().getEntry(i),  "#FFD700");
    }
}
