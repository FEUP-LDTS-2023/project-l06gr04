package org.example.gui;

import java.io.IOException;

public interface WindowInterface {
    KEY processKey() throws IOException;
    enum KEY {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}
