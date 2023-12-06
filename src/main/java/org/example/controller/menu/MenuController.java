package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.WindowInterface;
import org.example.model.menu.Menu;
import org.example.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelected(0)) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}

