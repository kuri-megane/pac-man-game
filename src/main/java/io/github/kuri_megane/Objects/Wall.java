package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Objects.Color.Blue;

public class Wall implements GameObjects {

    private static final Blue blue = new Blue(" ");
    private static final String displayChar = blue.coloringBack();
    private static final boolean goFlag = false;
    private static final String key = "w";

    public Wall() {
    }


    /**
     * Wall をどのように表示させるか取得します．
     *
     * @return 表示用の文字
     */
    public String getChar() {
        return displayChar;
    }

    /**
     * この Wall のある位置に移動できるか取得します．
     * Wall は false です．
     *
     * @return 移動できるかどうかのフラグ
     */
    public boolean isGo() {
        return goFlag;
    }

    /**
     * Wall であることを示すキーを取得します．
     *
     * @return 文字列 "w" (private static final String key で指定)
     */
    public String getKey() {
        return key;
    }
}
