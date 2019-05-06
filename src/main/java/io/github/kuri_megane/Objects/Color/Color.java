package io.github.kuri_megane.Objects.Color;

public interface Color {

    /**
     * 指定された色で文字を着色して返します．
     *
     * @return 着色するコードが入った文字列
     */
    String coloringChar();

    /**
     * 指定された色で文字の背景を着色して返します．
     *
     * @return 着色するコードが入った文字列
     */
    String coloringBack();
}
