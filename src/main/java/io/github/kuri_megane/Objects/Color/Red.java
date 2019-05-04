package io.github.kuri_megane.Objects.Color;

public class Red implements Color {

    private String str;

    public Red(String str) {
        this.str = str;
    }

    public String coloringChar() {
        return "\u001b[00;31m" + str + "\u001b[00m";
    }

    public String coloringBack() {
        return "\u001b[00;41m" + str + "\u001b[00m";
    }

}
