package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Window implements WindowInterface {
    private Screen screen;

    public Window(Screen newScreen) {
        screen = newScreen;
    }

    public Window() {
        try {
            TerminalSize terminalSize = new TerminalSize(80, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao iniciar a tela", e);
        }
    }

    private void draw() throws IOException {
        screen.clear();
        //arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    @Override
    public KEY processKey() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return KEY.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return KEY.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return KEY.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return KEY.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return KEY.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return KEY.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return KEY.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return KEY.SELECT;

        return KEY.NONE;

    }

    public void run() throws IOException {

        while (true) {
            draw();
            KeyStroke keyStroke = screen.pollInput();
            if (keyStroke != null) {
                if (keyStroke.getKeyType() == KeyType.EOF || (keyStroke.getCharacter() != null && keyStroke.getCharacter() == 'q')) {
                    break;
                }
            }
        }
    }
}
