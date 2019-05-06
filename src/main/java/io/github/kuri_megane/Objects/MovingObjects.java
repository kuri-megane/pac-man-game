package io.github.kuri_megane.Objects;

public interface MovingObjects {

    /**
     * どの行か取得します．
     *
     * @return 行の数字
     */
    int getRow();

    /**
     * どの行にいるか設定します．
     *
     * @param row 行の数字
     */
    void setRow(int row);

    /**
     * どの列か取得します．
     *
     * @return 列の数字
     */
    int getCol();

    /**
     * どの列にいるか設定します．
     *
     * @param col 列の筋
     */
    void setCol(int col);

    /**
     * 直前にどの座標にいたか設定します．
     */
    void setBeforePoint();

    /**
     * スコアを加算します．
     * 獲得した(通過した) Cookie の数です．
     */
    void addScore();

    /**
     * スコアを取得します．
     *
     * @return スコアの値
     */
    int getScore();

    /**
     * 移動に失敗したときの挙動を定義します．
     */
    void failToMove();

}
