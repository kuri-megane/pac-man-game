package io.github.kuri_megane.Objects.Color;

public class Blue implements Color {

    private String str;

    public Blue(String str) {
        this.str = str;
    }

    public String coloringChar() {
        return "\u001b[00;34m" + str + "\u001b[00m";
    }

    public String coloringBack() {
        return "\u001b[00;44m" + str + "\u001b[00m";
    }
}
