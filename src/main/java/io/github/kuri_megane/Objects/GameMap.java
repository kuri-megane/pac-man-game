package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {

    // ゲームのオブジェクトの配置 幅と高さ
    private final int gameMapHeight = 20;
    private final int gameMapWidth = 23;
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
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w",},
                {"w", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "w",},
                {"w", "c", "c", "w", "w", "c", "w", "w", "w", "c", "w", "w", "w", "c", "w", "w", "w", "c", "w", "c", "c", "c", "w",},
                {"w", "c", "c", "w", "w", "c", "w", "w", "c", "c", "c", "w", "w", "c", "w", "w", "w", "c", "w", "w", "c", "w", "w",},
                {"w", "c", "c", "c", "w", "c", "w", "w", "c", "w", "c", "w", "w", "c", "w", "w", "w", "c", "w", "w", "c", "w", "w",},
                {"w", "c", "w", "c", "w", "c", "w", "w", "c", "w", "c", "w", "w", "c", "c", "w", "c", "c", "w", "w", "c", "w", "w",},
                {"w", "c", "w", "c", "w", "c", "w", "c", "c", "w", "c", "c", "w", "w", "c", "w", "c", "w", "w", "w", "c", "w", "w",},
                {"w", "c", "w", "c", "c", "c", "w", "c", "w", "w", "w", "c", "w", "w", "c", "w", "c", "w", "w", "w", "c", "w", "w",},
                {"w", "c", "w", "w", "c", "c", "w", "c", "c", "c", "c", "c", "w", "w", "c", "c", "c", "w", "w", "w", "c", "w", "w",},
                {"w", "c", "w", "w", "c", "c", "w", "c", "w", "w", "w", "c", "w", "w", "w", "c", "w", "w", "w", "c", "c", "c", "w",},
                {"w", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "w",},
                {"w", "c", "c", "c", "c", "c", "w", "c", "c", "c", "w", "c", "c", "w", "w", "w", "c", "c", "w", "c", "c", "c", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "w", "c", "w", "w", "c", "c", "w", "w", "w", "c", "c", "w", "c", "w", "w", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "w", "c", "w", "w", "c", "c", "c", "w", "c", "c", "c", "w", "c", "w", "w", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "w", "c", "w", "w", "c", "w", "c", "w", "c", "w", "c", "w", "c", "c", "c", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "w", "c", "w", "w", "c", "w", "c", "w", "c", "w", "c", "w", "c", "w", "w", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "w", "c", "w", "w", "c", "w", "c", "c", "c", "w", "c", "w", "c", "w", "w", "w",},
                {"w", "w", "w", "c", "w", "w", "w", "c", "c", "c", "w", "c", "w", "w", "c", "w", "w", "c", "w", "c", "c", "c", "w",},
                {"w", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "w",},
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w",},
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
                gameMap[row][col] = new Wall();
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
     * MovingObjects が通過した位置のオブジェクトを書き換えます．
     *
     * @param obj   MovingObjects
     * @param after 移動後の座標
     */
    public void move(MovingObjects obj, Point after) {

        // 移動先が Nothing オブジェクトなら
        if (gameMap[after.getRow()][after.getCol()] instanceof Nothing) {

            // 移動元 書き換え
            gameMap[obj.getRow()][obj.getCol()] = new Nothing();
            // 移動先 書き換え
            gameMap[after.getRow()][after.getCol()] = (GameObjects) obj;

            // MovingObject の座標更新
            obj.setBeforePoint();
            obj.setRow(after.getRow());
            obj.setCol(after.getCol());

            return;
        }

        // 移動先が Cookie オブジェクトなら
        if (gameMap[after.getRow()][after.getCol()] instanceof Cookie) {

            // 移動元 書き換え
            gameMap[obj.getRow()][obj.getCol()] = new Nothing();
            // 移動先 書き換え
            gameMap[after.getRow()][after.getCol()] = (GameObjects) obj;

            // MovingObject の座標更新
            obj.setBeforePoint();
            obj.setRow(after.getRow());
            obj.setCol(after.getCol());

            // クッキーの数を減らす
            numOfObjects.put("c", numOfObjects.get("c") - 1);

            // 得点付与
            obj.addScore();

            return;
        }

        // 移動先が PacMan オブジェクトなら (必然的に obj は Monster)
        if (gameMap[after.getRow()][after.getCol()] instanceof PacMan) {

            // 移動元 書き換え
            gameMap[obj.getRow()][obj.getCol()] = new Nothing();
            // 移動先 書き換え
            gameMap[after.getRow()][after.getCol()] = new Ban();

            // ゲーム終了にする
            numOfObjects.put("c", 0);

            return;
        }

        // 移動先が Monster オブジェクトなら
        if (gameMap[after.getRow()][after.getCol()] instanceof Monster) {

            // 移動するオブジェクトが PacMan ならば
            if (obj instanceof PacMan) {
                // 移動元 書き換え
                gameMap[obj.getRow()][obj.getCol()] = new Nothing();
                // 移動先 書き換え
                gameMap[after.getRow()][after.getCol()] = new Ban();

                // ゲーム終了にする
                numOfObjects.put("c", 0);

                return;
            }
        }

        // それ以外は移動できないときなので
        obj.failToMove();
    }

    /**
     * MovingObjects を配置します．
     *
     * @param obj MovingObjects
     */
    public void put(MovingObjects obj) {

        // 移動先が Nothing オブジェクトなら
        if (gameMap[obj.getRow()][obj.getCol()] instanceof Nothing) {

            // 配置先 書き換え
            gameMap[obj.getRow()][obj.getCol()] = (GameObjects) obj;

            // MovingObject の座標更新
            obj.setRow(obj.getRow());
            obj.setCol(obj.getCol());

            return;
        }

        // 移動先が Cookie オブジェクトなら
        if (gameMap[obj.getRow()][obj.getCol()] instanceof Cookie) {

            // 配置先 書き換え
            gameMap[obj.getRow()][obj.getCol()] = (GameObjects) obj;

            // MovingObject の座標更新
            obj.setRow(obj.getRow());
            obj.setCol(obj.getCol());

            // クッキーの数を減らす
            numOfObjects.put("c", numOfObjects.get("c") - 1);

            // 得点付与
            obj.addScore();

            return;
        }
        throw new IndexOutOfBoundsException("配置先の座標の GameObjects を確認してください");
    }

    /**
     * ゲームの終了条件である Cookie オブジェクトが残っているかどうかを判定します．
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
    public List<String> createDisplayStrings() {

        // 描画内容の1列分の整形は StringBuilder に頼る
        StringBuilder line = new StringBuilder();

        // 1列ずつ整形したものを List にする
        List lines = new ArrayList<String>();

        for (int row = 0; row < getGameMapHeight(); row++) {

            // いったんクリア
            line.setLength(0);

            for (int col = 0; col < getGameMapWidth(); col++) {
                line.append(get(row, col).getChar());
            }
            lines.add(line.toString());
        }
        return lines;
    }
}
