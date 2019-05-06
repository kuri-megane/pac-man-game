package io.github.kuri_megane.Objects;

/**
 * Nothing で生成したインスタンスは何も無いことを示すオブジェクトです
 */
public class Nothing implements GameObjects {

    private static final String displayChar = " ";
    private static final boolean goFlag = true;
    private static final String key = "n";

    public Nothing() {
    }

    /**
     * Nothing をどのように表示させるか取得します．
     *
     * @return 表示用の文字
     */
    public String getChar() {
        return displayChar;
    }

    /**
     * この Nothing のある位置に移動できるか取得します．
     * Nothing は true です．
     *
     * @return 移動できるかどうかのフラグ
     */
    public boolean isGo() {
        return goFlag;
    }

    /**
     * Nothing であることを示すキーを取得します．
     *
     * @return 文字列 "n" (private static final String key で指定)
     */
    public String getKey() {
        return key;
    }
}
