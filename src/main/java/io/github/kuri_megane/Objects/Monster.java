package io.github.kuri_megane.Objects;

public class Monster implements GameObjects {

    private static final String displayChar = "×";
    private static final boolean goFlag = false;
    private static final String key = "m";

    public Monster() {
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
