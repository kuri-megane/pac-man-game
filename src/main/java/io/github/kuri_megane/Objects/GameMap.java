package io.github.kuri_megane.Objects;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    // ゲームのオブジェクト配置定義
    // XXX: 一旦ここに書き連ねていく
    private String[][] strGameObjects = {
            {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
            {"w", "c", "c", "c", "c", "m", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "w"},
            {"w", "c", "w", "w", "w", "w", "w", "c", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
            {"w", "p", "c", "c", "c", "c", "c", "c", "c", "c", "c", "n", "c", "c", "c", "c", "w"},
            {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}
    };

    // ゲームオブジェクト
    private GameObjects[][] gameObjects = new GameObjects[strGameObjects.length][strGameObjects[0].length];
    // 各オブジェクトの数
    private Map<String, Integer> numOfObjects = new HashMap<String, Integer>();

    public GameMap() {
        create();
        count();
    }

    /**
     * 文字列配列 strGameObjects で与えられた GameObject の配置を
     * インスタンスの配列に変換します．
     */
    public void create() {

        for (int row = 0; row < strGameObjects.length; row++) {
            for (int col = 0; col < strGameObjects[row].length; col++) {

                // 壁
                if (strGameObjects[row][col].equals("w")) {
                    gameObjects[row][col] = new Wall();
                    continue;
                }
                // クッキー
                if (strGameObjects[row][col].equals("c")) {
                    gameObjects[row][col] = new Cookie();
                    continue;
                }
                // 何もない場所
                if (strGameObjects[row][col].equals("n")) {
                    gameObjects[row][col] = new Nothing();
                    continue;
                }

                // パックマン
                if (strGameObjects[row][col].equals("p")) {
                    gameObjects[row][col] = new PacMan();
                    continue;
                }
                // モンスター
                if (strGameObjects[row][col].equals("m")) {
                    gameObjects[row][col] = new Monster();
                    continue;
                }

                // それ以外
                gameObjects[row][col] = new Nothing();
                continue;
            }
        }
    }

    /**
     * ゲームの構成オブジェクトが各々いくつあるかカウントします.
     */
    public void count() {
        for (GameObjects[] row : gameObjects) {
            for (GameObjects obj : row) {
                Integer i = numOfObjects.get(obj.getKey());
                numOfObjects.put(obj.getKey(), i == null ? 1 : i + 1);
            }
        }
    }


    /**
     * 指定された座標について調べてオブジェクトを返します．
     *
     * @param x x座標
     * @param y y座標
     * @return 当該座標の該当するオブジェクト
     */
    public GameObjects get(int x, int y) {
        return gameObjects[x][y];
    }

    /**
     * パックマンが通過した位置のオブジェクトを書き換えます．
     *
     * @param x x座標
     * @param y y座標
     */
    public void rewrite(int x, int y) {
        if (gameObjects[x][y] instanceof Cookie) {

            // 書き換えの実施
            gameObjects[x][y] = new Nothing();

            // オブジェクト数も減らす
            numOfObjects.put("c", numOfObjects.get("c") - 1);
        }
    }

    /**
     * ゲームの終了条件であるクッキーが残っているかどうかを判定します．
     *
     * @return ゲームが続くかどうか
     */
    public boolean isProceed() {

        if (numOfObjects.get("c") > 1) {
            return true;
        }
        return false;
    }
}
