package io.github.kuri_megane.Layer;

import io.github.kuri_megane.GameData;

import java.util.ArrayList;
import java.util.List;

public class EndRoll extends Display {

    private static final List<String> title = new ArrayList<String>();

    public EndRoll() {
        super();
    }

    /**
     * タイトル文字列の整形
     *
     * @param gameData ゲームデータが保存されたインスタンス
     * @return 整形した文字列
     */
    public List<String> createResultStrings(GameData gameData) {

        String strResult = "";
        String strIsDead = "";

        // プレイヤーの勝敗を決める
        if (gameData.getPlayerScore() < gameData.getMonsterScore()) {
            strResult = "You lose...";
        }
        if (gameData.getPlayerScore() > gameData.getMonsterScore()) {
            strResult = "You WIN!!";
        }
        if (gameData.getPlayerScore() == gameData.getMonsterScore()) {
            strResult = "DRAW";
        }

        if (gameData.isDead()) {
            strIsDead = "You Dead... GAME OUT!!";
        }

        // XXX: ここにベタ書きするの良くない
        title.add(" ____            __  __              ____                      ");
        title.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        title.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        title.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        title.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        title.add("");
        title.add("                              End                                ");
        title.add("");
        title.add("                      Name: " + gameData.getName());
        title.add("                Your Score: " + gameData.getPlayerScore());
        title.add("             Monster Score: " + gameData.getMonsterScore());
        title.add("");
        title.add("                         " + strResult);
        title.add("");
        title.add("                  " + strIsDead);

        return title;
    }
}
