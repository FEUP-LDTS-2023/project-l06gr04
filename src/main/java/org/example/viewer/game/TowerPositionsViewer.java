package org.example.viewer.game;
import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.TowerPositions;
import org.example.states.GameState;

public class TowerPositionsViewer implements ElementViewer<TowerPositions>{
    @Override
    public void draw(TowerPositions towerPositions, Window window) {
        window.drawText(towerPositions.getActPosition(), "P", "WHITE");
    }
}
