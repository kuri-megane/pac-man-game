package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Objects.Color.Red;

public class Ban implements GameObjects {

    private static final Red red = new Red(" ");
    private static final String displayChar = red.coloringBack();
    private static final boolean goFlag = true;
    private static final String key = "w";

    public Ban() {
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
