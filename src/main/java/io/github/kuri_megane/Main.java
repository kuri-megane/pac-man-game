package io.github.kuri_megane;

import io.github.kuri_megane.Layer.EndRoll;
import io.github.kuri_megane.Layer.StartMenu;

public class Main {
    public static void main(String[] args) {

        GamaData gamaData = new GamaData();

        // スタートメニューの表示
        StartMenu startMenu = new StartMenu();
        startMenu.getConsoleSize();
        startMenu.display(startMenu.createTitle(), 1000);
        String name = startMenu.inputName();
        gamaData.setName(name);

        // 1ゲーム目
        Game game1 = new Game();
        game1.setUp();
        game1.runMonster1();
        gamaData.setPlayerScore(game1.getPlayerScore() + gamaData.getPlayerScore());
        gamaData.setMonsterScore(game1.getMonsterScore() + gamaData.getMonsterScore());
        game1.tearDown();

        // 結果画面表示
        EndRoll endRoll = new EndRoll();
        endRoll.getConsoleSize();
        endRoll.display(endRoll.createResultStrings(gamaData), 5000);

        // 1ゲーム目をクリアしたら
        if (gamaData.getMonsterScore() < gamaData.getPlayerScore()) {

            // 2ゲーム目
            Game game2 = new Game();
            game2.setUp();
            game2.runMonster2();
            gamaData.setPlayerScore(game2.getPlayerScore() + gamaData.getPlayerScore());
            gamaData.setMonsterScore(game2.getMonsterScore() + gamaData.getMonsterScore());
            game2.tearDown();

            // 結果画面表示
            endRoll.getConsoleSize();
            endRoll.display(endRoll.createResultStrings(gamaData), 5000);
        }

        // 2ゲーム目をクリアしたら
        if (gamaData.getMonsterScore() < gamaData.getPlayerScore()) {

            // 3ゲーム目
            Game game3 = new Game();
            game3.setUp();
            game3.runMonster4();
            gamaData.setPlayerScore(game3.getPlayerScore() + gamaData.getPlayerScore());
            gamaData.setMonsterScore(game3.getMonsterScore() + gamaData.getMonsterScore());
            game3.tearDown();

            // 結果画面表示
            endRoll.getConsoleSize();
            endRoll.display(endRoll.createResultStrings(gamaData), 5000);
        }

        // 終了
        // XXX: スレッドがうまく終了できていないため
        System.exit(0);
    }
}
