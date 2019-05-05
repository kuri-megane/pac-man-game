package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.util.Random;

public class Monster extends Point implements GameObjects, MovingObjects {

    private static final String displayChar = "×";
    private static final boolean goFlag = false;
    private static final String key = "m";
    private int score = 0;

    // 前にいた座標
    private Point before;

    public Monster(int row, int col) {
        super(row, col);
        before = new Point(row, col);
    }

    /**
     * Monster をどのように表示させるか取得します．
     *
     * @return 表示用の文字
     */
    public String getChar() {
        return displayChar;
    }

    /**
     * この Monster のある位置に移動できるか取得します．
     * Monster は false です．
     *
     * @return
     */
    public boolean isGo() {
        return goFlag;
    }

    /**
     * Monster であることを示すキーを取得します．
     *
     * @return 文字列 "m"
     */
    public String getKey() {
        return key;
    }

    /**
     * Monster の次の移動先を決めます．
     *
     * @return 次の移動先の座標
     */
    public Point next() {

        Point after = new Point(0, 0);
        Random random = new Random();

        // 最大で8近傍にずれる
        after.setRow(getRow() + random.nextInt(3) - 1);
        after.setCol(getCol() + random.nextInt(3) - 1);

        return after;
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

    }

    /**
     * 直前座標の保持
     */
    public void setBeforePoint() {
        before.setRow(super.getRow());
        before.setCol(super.getCol());
    }
}
