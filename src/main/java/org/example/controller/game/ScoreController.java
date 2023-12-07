package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;

import java.io.IOException;

public class ScoreController extends GameController {
    private final Score scoreModel;

    public ScoreController(Arena arena, Score scoreModel) {
        super(arena);
        this.scoreModel = scoreModel;
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        // Lógica específica do ScoreController
        updateScore();

        // Atualiza a visualização do score
        //scoreViewer.updateScore(scoreModel.getScore());
    }

    private void updateScore() {
        // Lógica para atualizar o score com base na ação do jogador
        // Por exemplo, incrementar o score ao matar um monstro

    }
}