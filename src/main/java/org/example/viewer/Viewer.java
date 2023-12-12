package org.example.viewer;

import org.example.gui.Window;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(Window window) throws IOException {
        window.clear();
        drawElements(window);
        window.refresh();
    }

    public abstract void drawElements(Window window);
}
