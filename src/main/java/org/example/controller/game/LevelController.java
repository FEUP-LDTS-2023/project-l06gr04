package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Level;
import org.example.model.game.arena.Arena;

import java.io.IOException;

public class LevelController extends GameController {

    private final Level level;


    public LevelController(Arena arena, Level level) {
        super(arena);
        this.level = level;

    }

    public int getLevel(){
        return level.getLevel();
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (getModel() != null) {
            level.updateLevel(getModel().getScore());
        }
    }
}
