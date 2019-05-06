package io.github.kuri_megane.Objects.Color;

public class Blue implements Color {

    private String str;

    /**
     * 文字列または文字背景を 青色 に着色します．
     *
     * @param str 着色したい文字列
     */
    public Blue(String str) {
        this.str = str;
    }

    /**
     * 指定された色で文字を 青色 にして返します．
     *
     * @return 着色するコードが入った文字列
     */
    public String coloringChar() {
        return "\u001b[00;34m" + str + "\u001b[00m";
    }

    /**
     * 指定された色で文字の背景を 青色 にして返します．
     *
     * @return 着色するコードが入った文字列
     */
    public String coloringBack() {
        return "\u001b[00;44m" + str + "\u001b[00m";
    }
}
