package org.example.model.game;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore(int points) {
        score += points;
    }

    // Outros métodos relacionados ao modelo de score, se necessário
}
