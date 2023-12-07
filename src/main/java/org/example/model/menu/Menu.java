package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> title;
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.title = Arrays.asList("$$$$$$$$\\                                                $$$$$$$\\             $$$$$$\\                                         ",
                "\\__$$  __|                                               $$  __$$\\           $$  __$$\\                                        ",
                "   $$ | $$$$$$\\  $$\\  $$\\  $$\\  $$$$$$\\   $$$$$$\\        $$ |  $$ | $$$$$$\\  $$ /  \\__|$$$$$$\\  $$$$$$$\\   $$$$$$$\\  $$$$$$\\  ",
                "   $$ |$$  __$$\\ $$ | $$ | $$ |$$  __$$\\ $$  __$$\\       $$ |  $$ |$$  __$$\\ $$$$\\    $$  __$$\\ $$  __$$\\ $$  _____|$$  __$$\\ ",
                "   $$ |$$ /  $$ |$$ | $$ | $$ |$$$$$$$$ |$$ |  \\__|      $$ |  $$ |$$$$$$$$ |$$  _|   $$$$$$$$ |$$ |  $$ |\\$$$$$$\\  $$$$$$$$ |",
                "   $$ |$$ |  $$ |$$ | $$ | $$ |$$   ____|$$ |            $$ |  $$ |$$   ____|$$ |     $$   ____|$$ |  $$ | \\____$$\\ $$   ____|",
                "   $$ |\\$$$$$$  |\\$$$$$\\$$$$  |\\$$$$$$$\\ $$ |            $$$$$$$  |\\$$$$$$$\\ $$ |     \\$$$$$$$\\ $$ |  $$ |$$$$$$$  |\\$$$$$$$\\ ",
                "   \\__| \\______/  \\_____\\____/  \\_______|\\__|            \\_______/  \\_______|\\__|      \\_______|\\__|  \\__|\\_______/  \\_______|");
        this.entries = Arrays.asList("Level 1", "Level 2", "Level 3", "Exit");
    }
    public String getTitle(int i){
        return title.get(i);
    }
    public int getTitleSize(){
        return this.title.size();
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

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(entries.size() - 1);
    }

    public boolean isSelectedLevel(int level) {
        return isSelected(level - 1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
