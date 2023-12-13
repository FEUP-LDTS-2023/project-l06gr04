package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class Controls {
    private final List<String> entries;

    public Controls() {
        this.entries = Arrays.asList("Press 1 to 9 to choose where you want to create or update a tower", "Press c to create a CanonTower","Press a to create a ArcherTower","Press m to create a MageTower","Press u to update a Tower","Press q to return to Menu");
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
