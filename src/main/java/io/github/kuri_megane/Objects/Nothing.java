package io.github.kuri_megane.Objects;

public class Nothing implements GameObjects {

    private static final String displayChar = " ";
    private static final boolean goFlag = true;
    private static final String key = "n";

    public Nothing() {
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
