package org.example.viewer.menu;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Leaderboard;
import org.example.viewer.Viewer;


public class LeaderboardViewer extends Viewer<Leaderboard> {


    public LeaderboardViewer(Leaderboard leaderboard) {
        super(leaderboard);
    }

    @Override
    public void drawElements(Window window) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            window.drawText(new Position(5,2  + i), getModel().getTitle(i), "WHITE");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            window.drawText(new Position(10, 14 + i*5), getModel().getEntry(i),  "#FFD700");
        int count=0;
        for (String i: getModel().getScores()) {
            window.drawText(new Position(13, 14 + count * 5), i, "#FFD700");
            count++;
        }
    }
}
