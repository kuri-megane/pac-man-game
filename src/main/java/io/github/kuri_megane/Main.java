package io.github.kuri_megane;

import io.github.kuri_megane.Layer.EndRoll;
import io.github.kuri_megane.Layer.StartMenu;

public class Main {
    public static void main(String[] args) {

        GamaData gamaData = new GamaData();

        // スタートメニューの表示
        StartMenu startMenu = new StartMenu();
        startMenu.getConsoleSize();
        startMenu.display(startMenu.createTitle());
        String name = startMenu.inputName();
        gamaData.setName(name);

        // 1ゲーム目
        Game game = new Game();
        game.run();
        int playerScore = game.getPlayerScore();
        int monsterScore = game.getMonsterScore();
        gamaData.setPlayerScore(playerScore + gamaData.getPlayerScore());
        gamaData.setMonsterScore(monsterScore + gamaData.getMonsterScore());

        // エンドロール
        EndRoll endRoll = new EndRoll();
        endRoll.getConsoleSize();
        endRoll.display(endRoll.createResultStrings(gamaData));

        // 終了
        // XXX: スレッドがうまく終了できていないため
        System.exit(0);
    }
}
