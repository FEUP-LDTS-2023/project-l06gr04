package org.example;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;

    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
