package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.arena.Arena;
import org.example.model.game.level.LevelModel;
import org.example.viewer.game.LevelViewer;

import java.io.IOException;

public class LevelController extends GameController {
    private final LevelModel levelModel;
    private final LevelViewer levelViewer;

    public LevelController(Arena arena, LevelModel levelModel, LevelViewer levelViewer) {
        super(arena);
        this.levelModel = levelModel;
        this.levelViewer = levelViewer;
    }

    @Override
    public void addListeners() {
        levelModel.addLevelChangeListener(levelViewer);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        // Lógica específica do LevelController (se necessário)
    }


}
