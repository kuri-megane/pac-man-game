package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Objects.Color.Blue;

public class Wall implements GameObjects {

    private static final Blue blue = new Blue(" ");
    private static final String displayChar = blue.coloringBack();
    private static final boolean goFlag = false;
    private static final String key = "w";

    public Wall() {
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
