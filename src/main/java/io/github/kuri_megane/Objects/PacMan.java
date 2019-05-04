package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

public class PacMan extends Point implements GameObjects, MovingObjects {

    private static final String defaultChar = "●";
    private static final boolean goFlag = true;
    private static final String key = "p";

    public PacMan(int row, int col) {
        super(row, col);
    }

    public String getChar() {
        return defaultChar;
    }

    public boolean isGo() {
        return goFlag;
    }

    public String getKey() {
        return key;
    }
}
