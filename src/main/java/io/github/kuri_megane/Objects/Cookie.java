package io.github.kuri_megane.Objects;

/**
 * クッキーを定義したクラス
 * GameObjects を継承
 * MovingObjects は継承していない
 * つまり動くことはない
 */
public class Cookie implements GameObjects {

    private static final String displayChar = "★";
    private static final boolean goFlag = true;
    private static final String key = "c";

    public Cookie() {
    }

    /**
     * Cookie をどのように表示させるか取得します．
     *
     * @return 表示用の文字
     */
    public String getChar() {
        return displayChar;
    }

    /**
     * この Cookie のある位置に移動できるか取得します．
     * Cookie は true です．
     *
     * @return 移動できるかどうかのフラグ
     */
    public boolean isGo() {
        return goFlag;
    }

    /**
     * Cookie であることを示すキーを取得します．
     *
     * @return 文字列 "c" (private static final String key で指定)
     */
    public String getKey() {
        return key;
    }
}
