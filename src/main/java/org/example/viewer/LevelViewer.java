package org.example.viewer;

import org.example.Level;
import org.example.gui.Window;

public class LevelViewer extends Viewer<Level> {

    public LevelViewer(Level level) {
        super(level);
    }

    @Override
    protected void drawElements(Window window) {
        Level level = getModel();

        // Lógica para desenhar elementos específicos do nível
        // Aqui, apenas um exemplo simples de exibição do número do nível

        window.drawText("Level: " + level.getLevelNumber(), 1, 1);

        // Adicione lógica adicional para desenhar outras informações do nível
    }
}
