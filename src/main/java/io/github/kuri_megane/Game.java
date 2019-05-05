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
    private GameMap gameMap = new GameMap();
    private PlayScreen playScreen = new PlayScreen();
    private PacMan pacMan = new PacMan(9, 11);
    private Monster monster1 = new Monster(9, 1);
    private Monster monster2 = new Monster(9, 20);
    private Monster monster3 = new Monster(16, 14);
    private Monster monster4 = new Monster(1, 1);
    private Controller controller = new Controller(gameMap, pacMan);


    public Game() {
    }

    public void setUp() {

        // コンソールサイズの取得
        playScreen.getConsoleSize();

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

        // 一時的に変更
        // LogManager.getLogManager().reset();
    }

    /**
     * 1ゲームの開始 モンスター1つ
     */
    public void runMonster1() {

        // パックマン配置
        gameMap.put(pacMan);

        // モンスター1 配置
        gameMap.put(monster1);

        // 描画
        playScreen.display(gameMap.createDisplayStrings(), 100);

        // Cookie がある限り
        while (gameMap.isProceed()) {

            // Monster の移動
            Point nextMonster1 = monster1.next(gameMap, pacMan);
            gameMap.move(monster1, nextMonster1);

            // 描画
            playScreen.display(gameMap.createDisplayStrings(), 100);

        }
    }

    /**
     * 1ゲームの開始 モンスター2つ
     */
    public void runMonster2() {

        // パックマン配置
        gameMap.put(pacMan);

        // モンスター1 配置
        gameMap.put(monster1);

        // モンスター2 配置
        gameMap.put(monster2);

        // 描画
        playScreen.display(gameMap.createDisplayStrings(), 100);

        // Cookie がある限り
        while (gameMap.isProceed()) {

            // Monster の移動
            Point nextMonster1 = monster1.next(gameMap, pacMan);
            gameMap.move(monster1, nextMonster1);

            // Monster の移動
            Point nextMonster2 = monster2.next(gameMap, pacMan);
            gameMap.move(monster2, nextMonster2);

            // 描画
            playScreen.display(gameMap.createDisplayStrings(), 100);

        }
    }

    /**
     * 1ゲームの開始 モンスター4つ
     */
    public void runMonster4() {

        // モンスター1 配置
        gameMap.put(monster1);

        // モンスター2 配置
        gameMap.put(monster2);

        // モンスター3 配置
        gameMap.put(monster3);

        // モンスター4 配置
        gameMap.put(monster4);

        // 描画
        playScreen.display(gameMap.createDisplayStrings(), 100);

        // Cookie がある限り
        while (gameMap.isProceed()) {

            // Monster の移動
            Point nextMonster1 = monster1.next(gameMap, pacMan);
            gameMap.move(monster1, nextMonster1);

            // Monster の移動
            Point nextMonster2 = monster2.next(gameMap, pacMan);
            gameMap.move(monster2, nextMonster2);

            // Monster の移動
            Point nextMonster3 = monster3.next(gameMap, pacMan);
            gameMap.move(monster3, nextMonster3);

            // Monster の移動
            Point nextMonster4 = monster4.next(gameMap, pacMan);
            gameMap.move(monster4, nextMonster4);

            // 描画
            playScreen.display(gameMap.createDisplayStrings(), 100);

        }
    }

    public void tearDown() {

        // 獲得した点数(=獲得した Cookie の数)を入れる
        playerScore = pacMan.getScore();
        monsterScore += monster1.getScore();
        monsterScore += monster2.getScore();
        monsterScore += monster3.getScore();
        monsterScore += monster4.getScore();

        // コントローラー削除
        GlobalScreen.removeNativeKeyListener(controller);
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getMonsterScore() {
        return monsterScore;
    }
}
