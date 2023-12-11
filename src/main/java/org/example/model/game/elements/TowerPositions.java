package org.example.model.game.elements;

import java.util.List;
import java.util.Arrays;
import org.example.model.game.Position;

public class TowerPositions extends Element {
    private Position actPosition;
    private List<Position> availablePositions;

    public TowerPositions(int x, int y) {
        super(x, y);
        this.availablePositions=Arrays.asList(new Position(45,65), new Position(81,65));
        this.actPosition = availablePositions.get(0);
    }
    public Position getActPosition(){
        return this.actPosition;
    }
}

