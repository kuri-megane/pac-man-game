package io.github.kuri_megane;

/**
 * 2次元座標のクラス
 */
public class Point {

    private int row;
    private int col;

    /**
     * 初期座標を決めます．
     *
     * @param row どこの行か
     * @param col どこの列か
     */
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }


    /**
     * どの行か取得します．
     *
     * @return 行の数字
     */
    public int getRow() {
        return row;
    }

    /**
     * どの行にいるか設定します．
     *
     * @param row 行の数字
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * どの列か取得します．
     *
     * @return 列の数字
     */
    public int getCol() {
        return col;
    }

    /**
     * どの列にいるか設定します．
     *
     * @param col 列の筋
     */
    public void setCol(int col) {
        this.col = col;
    }

}
