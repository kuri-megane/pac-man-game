package io.github.kuri_megane;

import io.github.kuri_megane.Layer.PlayScreen;
import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.Monster;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;

public class Game {

    private int scoreOfThisGame = 0;

    public Game() {
    }

    /**
     * 1ゲームの開始
     */
    public void run() {

        GameMap gameMap = new GameMap();
        PlayScreen playScreen = new PlayScreen();

        // コンソールサイズの取得
        playScreen.getConsoleSize();

        // パックマン配置
        PacMan pacMan = new PacMan(9, 11);
        gameMap.put(pacMan);

        // モンスター配置
        Monster monster = new Monster(9, 1);
        gameMap.put(monster);

        // コントローラー配置
        Controller controller = new Controller(gameMap, pacMan);
        // 標準入力をフックしてなかったらフック
        if (!GlobalScreen.isNativeHookRegistered()) {
            try {
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        GlobalScreen.addNativeKeyListener(controller);
        LogManager.getLogManager().reset();

        // 描画
        playScreen.display(gameMap.createDisplayStrings());

        // Cookie がある限り
        while (gameMap.isProceed()) {

            // Monster の移動，移動できるまでずっと
            while (true) {

                // 移動先の候補
                Point next = new Point(monster.next().getRow(), monster.next().getCol());

                // 移動できそうであれば
                if (gameMap.get(next.getRow(), next.getCol()).isGo()) {

                    // 移動の実施
                    gameMap.move(monster, next);

                    break;
                }
            }

            // 描画
            playScreen.display(gameMap.createDisplayStrings());

        }

        // 一時停止
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // コントローラー削除
        GlobalScreen.removeNativeKeyListener(controller);
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        // 獲得した点数(=獲得した Cookie の数)を入れる
        scoreOfThisGame = pacMan.getScore();
    }

    public int getScoreOfThisGame() {
        return scoreOfThisGame;
    }
}
