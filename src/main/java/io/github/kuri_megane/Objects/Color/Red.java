package io.github.kuri_megane.Objects.Color;

public class Red implements Color {

    private String str;

    /**
     * 文字列または文字背景を 赤色 に着色します．
     *
     * @param str 着色したい文字列
     */
    public Red(String str) {
        this.str = str;
    }

    /**
     * 指定された色で文字を 赤色 にして返します．
     *
     * @return 着色するコードが入った文字列
     */
    public String coloringChar() {
        return "\u001b[00;31m" + str + "\u001b[00m";
    }

    /**
     * 指定された色で文字の背景を 赤色 して返します．
     *
     * @return 着色するコードが入った文字列
     */
    public String coloringBack() {
        return "\u001b[00;41m" + str + "\u001b[00m";
    }

}
