package io.github.kuri_megane;

import io.github.kuri_megane.Layer.EndRoll;
import io.github.kuri_megane.Layer.StartMenu;

/**
 * 実行のエンドポイント
 * ゲームはここから開始させる
 */
public class Main {
    public static void main(String[] args) {

        GameData gameData = new GameData();

        // スタートメニューの表示
        StartMenu startMenu = new StartMenu();
        startMenu.getConsoleSize();
        startMenu.display(startMenu.createTitle(), 1000);
        String name = startMenu.inputName();
        gameData.setName(name);

        // 1ゲーム目
        Game game1 = new Game();
        game1.setUp();
        game1.runMonster1();
        game1.tearDown();
        gameData.setPlayerScore(game1.getPlayerScore() + gameData.getPlayerScore());
        gameData.setMonsterScore(game1.getMonsterScore() + gameData.getMonsterScore());
        gameData.setDead(game1.isPlayerDead());

        // 結果画面表示
        EndRoll endRoll = new EndRoll();
        endRoll.getConsoleSize();
        endRoll.display(endRoll.createResultStrings(gameData), 5000);

        // 死んでたら
        if (gameData.isDead()) {
            // return;
            // XXX: スレッドがうまく終了できていないため
            System.exit(0);
        }
        // 得点が低かったら
        if (gameData.getPlayerScore() <= gameData.getMonsterScore()) {
            // return;
            // XXX: スレッドがうまく終了できていないため
            System.exit(0);
        }

        // 2ゲーム目
        Game game2 = new Game();
        game2.setUp();
        game2.runMonster2();
        game2.tearDown();
        gameData.setPlayerScore(game2.getPlayerScore() + gameData.getPlayerScore());
        gameData.setMonsterScore(game2.getMonsterScore() + gameData.getMonsterScore());
        gameData.setDead(game2.isPlayerDead());

        // 結果画面表示
        endRoll.getConsoleSize();
        endRoll.display(endRoll.createResultStrings(gameData), 5000);

        // 死んでたら
        if (gameData.isDead()) {
            // return;
            // XXX: スレッドがうまく終了できていないため
            System.exit(0);
        }
        // 得点が低かったら
        if (gameData.getPlayerScore() <= gameData.getMonsterScore()) {
            // return;
            // XXX: スレッドがうまく終了できていないため
            System.exit(0);
        }

        // 3ゲーム目
        Game game3 = new Game();
        game3.setUp();
        game3.runMonster4();
        game3.tearDown();
        gameData.setPlayerScore(game3.getPlayerScore() + gameData.getPlayerScore());
        gameData.setMonsterScore(game3.getMonsterScore() + gameData.getMonsterScore());
        gameData.setDead(game3.isPlayerDead());

        // 結果画面表示
        endRoll.getConsoleSize();
        endRoll.display(endRoll.createResultStrings(gameData), 5000);

        // 終了
        // XXX: スレッドがうまく終了できていないため
        System.exit(0);
    }
}
