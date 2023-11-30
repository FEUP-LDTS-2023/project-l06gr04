package org.example.controller;

import org.example.Game;
import org.example.gui.Window;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T newModel) {
        model = newModel;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, Window.KEY action, long time) throws IOException;
}
