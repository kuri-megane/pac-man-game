package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Objects.Color.Purple;
import io.github.kuri_megane.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * モンスターを定義したクラス
 * ここに動きなども含まれる
 */
public class Monster extends Point implements GameObjects, MovingObjects {

    private static final Purple purple = new Purple("×");
    private static final String displayChar = purple.coloringChar();
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
     * @return 移動できるかどうかのフラグ
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
     * @param gameMap 生成した gameMap インスタンス
     * @param pacMan  生成した pacMan インスタンス
     * @return 次の移動先の座標
     */
    public Point next(GameMap gameMap, PacMan pacMan) {

        // 上右下左の4方向
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        List<Point> candidates = new ArrayList<Point>();

        // 4方向でどこに動くか候補を決める
        for (int[] dir : directions) {

            // 4方向について探索
            int nextRow = this.getRow() + dir[0];
            int nextCol = this.getCol() + dir[1];

            // 障害物がある所へは行かない
            if (!gameMap.get(nextRow, nextCol).isGo()) {
                continue;
            }

            // 直前の座標を候補に入れておけば少し難易度が下がる
            // // 直前の座標は候補に入れない
            // if (nextRow == before.getRow() && nextCol == before.getCol()) {
            //     continue;
            // }

            candidates.add(new Point(nextRow, nextCol));
        }

        // 直前座標以外に選択肢が無いときは引き返す
        if (candidates.size() == 0) {
            return new Point(before.getRow(), before.getCol());
        }

        // 約半分の割合でどの方法で移動先を決めるか決定する
        Random random = new Random();

        if (random.nextBoolean()) {
            return nextRandom(candidates);
        }

        return nextChasePacMan(candidates, pacMan);
    }

    /**
     * Monster の次の移動先をランダムに決めます．
     *
     * @param candidates 移動先の座標の候補 next() で生成
     * @return 次の移動先の座標
     */
    private Point nextRandom(List<Point> candidates) {

        // ランダムに決める
        Random random = new Random();
        return candidates.get(random.nextInt(candidates.size()));

    }

    /**
     * Monster の次の移動先をパックマンを追うように決めます．
     *
     * @param candidates 移動先の座標の候補 next() で生成
     * @param pacMan     生成した PacMan のインスタンス
     * @return 次の移動先の座標
     */
    private Point nextChasePacMan(List<Point> candidates, PacMan pacMan) {

        // pacManとの距離スコアを計算して最も良いスコアの方へ移動させる
        Point bestMove = candidates.get(0);
        double bestDistanceScore = calcDistance(pacMan, candidates.get(0));

        for (int i = 1; i < candidates.size(); i++) {

            Point tmpMove = candidates.get(i);
            double tmpDistanceScore = calcDistance(pacMan, tmpMove);

            // 最もスコアの小さい(pacManに近い)動きを求める
            if (tmpDistanceScore < bestDistanceScore) {
                bestMove = tmpMove;
                bestDistanceScore = tmpDistanceScore;
            }
        }
        return bestMove;
    }

    /**
     * PacManとMonsterの移動先候補との距離を計算する
     * 縦方向よりも横方向の重みを大きくして横に優先して動くようにしている
     *
     * @param pacMan パックマン
     * @param p      移動先候補の座標
     * @return 距離ベースのスコア
     */
    private double calcDistance(PacMan pacMan, Point p) {
        return Math.pow(pacMan.getRow() - p.getRow(), 2) + (2 * Math.pow(pacMan.getCol() - p.getCol(), 2));
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
