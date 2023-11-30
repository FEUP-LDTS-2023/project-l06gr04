package org.example.states;


import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.Window;
import org.example.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {

    private final T model;

    public State(T newModel) {
        this.model = newModel;
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, Window window, long time) throws IOException {
        Window.KEY action = window.processKey();
        getController().step(game, action, time);
        getViewer().draw(window);
    }
}