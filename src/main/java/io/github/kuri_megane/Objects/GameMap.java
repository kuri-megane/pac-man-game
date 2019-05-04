package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    // ゲームのオブジェクトの配置 幅と高さ
    private final int gameMapHeight = 5;
    private final int gameMapWidth = 17;
    // ゲームのオブジェクトの配置 (文字型)
    private String[][] strGameMap = new String[gameMapHeight][gameMapWidth];
    // ゲームのオブジェクトの配置 (GameObject型)
    private GameObjects[][] gameMap = new GameObjects[gameMapHeight][gameMapWidth];
    // 各オブジェクトの数
    private Map<String, Integer> numOfObjects = new HashMap<String, Integer>();

    public GameMap() {
        setUp();
        convert();
        count();
    }

    public GameMap(String[][] strGameMap) {
        setUp(strGameMap);
        convert();
        count();
    }

    /**
     * デフォルトのゲームオブジェクトの配置を定義します．
     */
    public void setUp() {
        strGameMap = new String[][]{
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
                {"w", "n", "n", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "w"},
                {"w", "c", "w", "w", "w", "w", "w", "c", "w", "w", "w", "w", "w", "w", "w", "c", "w"},
                {"w", "n", "n", "c", "c", "c", "c", "c", "c", "c", "c", "n", "c", "c", "c", "c", "w"},
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}
        };
    }

    /**
     * ゲームオブジェクトの配置を定義します．
     *
     * @param stringArray 配置を記載したString型2次元配列
     */
    public void setUp(String[][] stringArray) {
        strGameMap = stringArray;
    }

    /**
     * 文字列配列 strGameMap で与えられた GameObject の配置を
     * インスタンスの配列に変換します．
     */
    public void convert() {

        for (int row = 0; row < strGameMap.length; row++) {
            for (int col = 0; col < strGameMap[row].length; col++) {

                // 壁
                if (strGameMap[row][col].equals("w")) {
                    gameMap[row][col] = new Wall();
                    continue;
                }
                // クッキー
                if (strGameMap[row][col].equals("c")) {
                    gameMap[row][col] = new Cookie();
                    continue;
                }
                // 何もない場所
                if (strGameMap[row][col].equals("n")) {
                    gameMap[row][col] = new Nothing();
                    continue;
                }

                // パックマン
                if (strGameMap[row][col].equals("p")) {
                    gameMap[row][col] = new PacMan(row, col);
                    continue;
                }
                // モンスター
                if (strGameMap[row][col].equals("m")) {
                    gameMap[row][col] = new Monster(row, col);
                    continue;
                }

                // それ以外
                gameMap[row][col] = new Nothing();
            }
        }
    }

    /**
     * ゲームの構成オブジェクトが各々いくつあるかカウントします.
     */
    public void count() {
        for (GameObjects[] row : gameMap) {
            for (GameObjects obj : row) {
                Integer i = numOfObjects.get(obj.getKey());
                numOfObjects.put(obj.getKey(), i == null ? 1 : i + 1);
            }
        }
    }


    /**
     * 指定された座標について調べてオブジェクトを返します．
     *
     * @param row 行
     * @param col 列
     * @return 当該座標の該当するオブジェクト
     */
    public GameObjects get(int row, int col) {
        return gameMap[row][col];
    }

    /**
     * パックマンが通過した位置のオブジェクトを書き換えます．
     *
     * @param obj   移動するゲームオブジェクト
     * @param after 移動後の座標
     */
    public void move(MovingObjects obj, Point after) {

        // Nothing オブジェクトなら
        if (gameMap[after.getRow()][after.getCol()] instanceof Nothing) {
            // 移動元 書き換え
            gameMap[obj.getRow()][obj.getCol()] = new Nothing();
            // 移動先 書き換え
            gameMap[after.getRow()][after.getCol()] = (GameObjects) obj;
            // MovingObject の座標更新
            obj.setRow(after.getRow());
            obj.setCol(after.getCol());

            return;
        }

        // Cookie オブジェクトなら
        if (gameMap[after.getRow()][after.getCol()] instanceof Cookie) {
            // 移動元 書き換え
            gameMap[obj.getRow()][obj.getCol()] = new Nothing();
            // 移動先 書き換え
            gameMap[after.getRow()][after.getCol()] = (GameObjects) obj;
            // MovingObject の座標更新
            obj.setRow(after.getRow());
            obj.setCol(after.getCol());
            // クッキーの数を減らす
            numOfObjects.put("c", numOfObjects.get("c") - 1);

            return;
        }

    }

    /**
     * ゲームの終了条件であるクッキーが残っているかどうかを判定します．
     *
     * @return ゲームが続くかどうか
     */
    public boolean isProceed() {

        if (numOfObjects.get("c") > 0) {
            return true;
        }
        return false;
    }

    /**
     * ゲームマップの高さを取得します．
     *
     * @return ゲームマップの高さの値
     */
    public int getGameMapHeight() {
        return gameMapHeight;
    }

    /**
     * ゲームマップの幅を取得します．
     *
     * @return ゲームマップの幅の値
     */
    public int getGameMapWidth() {
        return gameMapWidth;
    }

    /**
     * 描画用の文字列を整形します．
     *
     * @return ゲームオブジェクトが文字に変換された描画文字列
     */
    public String createDisplayStrings() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < getGameMapHeight(); row++) {
            for (int col = 0; col < getGameMapWidth(); col++) {
                stringBuilder.append(get(row, col).getChar());
            }
            stringBuilder.append("%n");
        }
        return stringBuilder.toString();
    }
}
