package io.github.kuri_megane.Objects;

public interface GameObjects {

    /**
     * 当該オブジェクトをどのように表示させるか取得します．
     *
     * @return 表示用の文字 ex. PacMan:"●"
     */
    String getChar();

    /**
     * 当該オブジェクトのある位置に移動できるか取得します．
     *
     * @return 移動できるのであれば true
     */
    boolean isGo();

    /**
     * 当該オブジェクトを示すキーを取得します．
     *
     * @return 文字列 ex. PacMan:"p"
     */
    String getKey();
}
