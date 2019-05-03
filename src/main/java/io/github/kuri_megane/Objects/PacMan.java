package io.github.kuri_megane.Objects;

public class PacMan implements GameObjects {

    private static final String defaultChar = "●";
    private static final boolean goFlag = true;
    private static final String key = "p";

    public PacMan() {
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
