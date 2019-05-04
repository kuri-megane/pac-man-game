package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

public class Monster extends Point implements GameObjects, MovingObjects  {

    private static final String displayChar = "×";
    private static final boolean goFlag = false;
    private static final String key = "m";

    public Monster(int row, int col) {
        super(row, col);
    }

    public String getChar() {
        return displayChar;
    }

    public boolean isGo() {
        return goFlag;
    }

    public String getKey() {
        return key;
    }
}
