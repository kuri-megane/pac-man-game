package io.github.kuri_megane;

import io.github.kuri_megane.Layer.PlayScreen;
import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.Monster;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;

public class Game {

    private int playerScore = 0;
    private int monsterScore = 0;

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

        // モンスター1 配置
        Monster monster1 = new Monster(9, 1);
        gameMap.put(monster1);

        // モンスター2 配置
        Monster monster2 = new Monster(9, 20);
        gameMap.put(monster2);

        // モンスター3 配置
        Monster monster3 = new Monster(16, 14);
        gameMap.put(monster3);

        // モンスター4 配置
        Monster monster4 = new Monster(1, 1);
        gameMap.put(monster4);

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
                Point nextMonster1 = new Point(monster1.next().getRow(), monster1.next().getCol());
                Point nextMonster2 = new Point(monster2.next().getRow(), monster2.next().getCol());
                Point nextMonster3 = new Point(monster3.next().getRow(), monster3.next().getCol());
                Point nextMonster4 = new Point(monster4.next().getRow(), monster4.next().getCol());

                // 移動できそうであれば
                if (gameMap.get(nextMonster1.getRow(), nextMonster1.getCol()).isGo()) {
                    gameMap.move(monster1, nextMonster1);
                    break;
                }
                if (gameMap.get(nextMonster2.getRow(), nextMonster2.getCol()).isGo()) {
                    gameMap.move(monster2, nextMonster2);
                    break;
                }
                if (gameMap.get(nextMonster3.getRow(), nextMonster3.getCol()).isGo()) {
                    gameMap.move(monster3, nextMonster3);
                    break;
                }
                if (gameMap.get(nextMonster4.getRow(), nextMonster1.getCol()).isGo()) {
                    gameMap.move(monster4, nextMonster4);
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
        playerScore = pacMan.getScore();
        monsterScore += monster1.getScore();
        monsterScore += monster2.getScore();
        monsterScore += monster3.getScore();
        monsterScore += monster4.getScore();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getMonsterScore() {
        return monsterScore;
    }
}
