package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Controls;


public class ControlsViewer extends Viewer<Controls> {


    public ControlsViewer(Controls controls) {
        super(controls);
    }

    @Override
    public void drawElements(Window window) {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            window.drawText(new Position(10, 8 + i*5), getModel().getEntry(i),  "#FFD700");
    }
}
