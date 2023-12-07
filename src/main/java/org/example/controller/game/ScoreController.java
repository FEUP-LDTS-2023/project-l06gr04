package org.example.controller.game;

import org.example.Game;
import org.example.gui.WindowInterface;
import org.example.model.game.Score;
import org.example.model.game.arena.Arena;
import org.example.viewer.game.ScoreViewer;

import java.io.IOException;

public class ScoreController extends GameController {
    private final Score scoreModel;
    private final ScoreViewer scoreView;

    public ScoreController(Arena arena, Score scoreModel, ScoreViewer scoreView) {
        super(arena);
        this.scoreModel = scoreModel;
        this.scoreView = scoreView;
    }
    @Override
    public void addListeners() {
        // Adiciona o listener da ScoreView
        scoreModel.addScoreChangeListener(scoreView);
    }
    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        // Atualizar o score com base em eventos do jogo (por exemplo, derrotar inimigos)
        updateScore();

        // Exibir o score na tela
        scoreView.displayScore(scoreModel.getScore());
    }

    private void updateScore() {
        // Lógica para atualizar o score com base em eventos do jogo
        // Exemplo: incrementar o score sempre que um inimigo for derrotado

    }
}
