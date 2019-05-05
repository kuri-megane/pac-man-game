package io.github.kuri_megane.Objects.Color;

public class Green {

    private String str;

    public Green(String str) {
        this.str = str;
    }

    public String coloringChar() {
        return "\u001b[00;32m" + str + "\u001b[00m";
    }

    public String coloringBack() {
        return "\u001b[00;42m" + str + "\u001b[00m";
    }
}
