package io.github.kuri_megane.Objects.Color;

public class Purple {

    private String str;

    public Purple(String str) {
        this.str = str;
    }

    public String coloringChar() {
        return "\u001b[00;35m" + str + "\u001b[00m";
    }

    public String coloringBack() {
        return "\u001b[00;45m" + str + "\u001b[00m";
    }
}
