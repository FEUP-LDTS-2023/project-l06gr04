package org.example.model.game.elements;

import org.example.model.game.Position;

import java.util.ArrayList;
import java.util.List;

public class TowerPositions {
    private final List<Position> entries;
    private int currentEntry = 0;
    public TowerPositions() {

        this.entries = new ArrayList<>(List.of(new Position(3,19),new Position(14,20),new Position(14,20),new Position(26,24),new Position(34,15),new Position(37,67),new Position(29,85)));
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public Position getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}