package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class Leaderboard {
    private final List<String> entries;

    public Leaderboard() {
        this.entries = Arrays.asList("1.", "2.","3.","4.","5.","6.");
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
