package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.awt.*;

public class PacMan extends Point implements GameObjects, MovingObjects {

    private static final String defaultChar = "●";
    private static final boolean goFlag = true;
    private static final String key = "p";
    private int score = 0;

    // 前にいた座標
    private Point before;

    public PacMan(int row, int col) {
        super(row, col);
        before = new Point(row, col);
    }

    /**
     * PacMan をどのように表示させるか取得します．
     *
     * @return 表示用の文字
     */
    public String getChar() {
        return defaultChar;
    }

    /**
     * この PacMan のある位置に移動できるか取得します．
     * PacMan は true です．
     *
     * @return
     */
    public boolean isGo() {
        return goFlag;
    }

    /**
     * PacMan であることを示すキーを取得します．
     *
     * @return 文字列 "p"
     */
    public String getKey() {
        return key;
    }

    /**
     * スコアを加算する
     */
    public void addScore() {
        score++;
    }

    /**
     * 現在のスコア(=獲得したCookieの数)を取得
     *
     * @return スコア
     */
    public int getScore() {
        return score;
    }

    /**
     * 移動先に移動できなかったときに使う
     */
    public void failToMove() {
        Toolkit.getDefaultToolkit().beep();
    }

    /**
     * 直前座標の保持
     */
    public void setBeforePoint() {
        before.setRow(super.getRow());
        before.setCol(super.getCol());
    }
}
