package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.game.elements.towers.ArcherTower;
import org.example.model.game.elements.towers.MageTower;
import org.example.model.game.elements.towers.Tower;

public class TowerViewer implements ElementViewer<Tower> {

    private final Tower tower;

    public TowerViewer(Tower tower) {
        this.tower = tower;
    }

    public Tower getTower() {
        return tower;
    }

    public Character getTowerSymbol() {
        if (tower instanceof MageTower) {
            return 'M';
        } else if (tower instanceof ArcherTower) {
            return 'A';
        } else{
            return 'C';
        }

    }

    @Override
    public void draw(Tower element, Window window) {
        Position position = tower.getPosition();
        Character towerSymbol = getTowerSymbol();
        window.drawTower(position, towerSymbol);
    }
}
