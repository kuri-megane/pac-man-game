package io.github.kuri_megane;

import io.github.kuri_megane.Layer.PlayScreen;
import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.Monster;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;


/**
 * 1ゲーム分の実行コードが入ってる
 */
public class Game {

    private int playerScore = 0;
    private int monsterScore = 0;
    private boolean playerDead = false;
    private GameMap gameMap = new GameMap();
    private PlayScreen playScreen = new PlayScreen();
    private PacMan pacMan = new PacMan(9, 11);
    private Monster monster1 = new Monster(9, 1);
    private Monster monster2 = new Monster(9, 21);
    private Monster monster3 = new Monster(3, 7);
    private Monster monster4 = new Monster(17, 21);
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

        LogManager.getLogManager().reset();
    }

    /**
     * 1ゲームの開始 モンスター1つ配置
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
     * 1ゲームの開始 モンスター2つ配置
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
     * 1ゲームの開始 モンスター4つ配置
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

    /**
     * ゲームの終了処理
     * スコアの保存とコントローラーの削除
     */
    public void tearDown() {

        // 獲得した点数(=獲得した Cookie の数)を入れる
        playerScore = pacMan.getScore();
        monsterScore += monster1.getScore();
        monsterScore += monster2.getScore();
        monsterScore += monster3.getScore();
        monsterScore += monster4.getScore();

        // パックマンが死んでるか確認
        if (gameMap.isDead()) {
            playerDead = true;
        }

        // コントローラー削除
        GlobalScreen.removeNativeKeyListener(controller);
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    /**
     * プレイヤー(PacMan)のスコアを取得する
     *
     * @return プレイヤーが獲得した Cookie の数
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * モンスターのスコアを取得する
     *
     * @return モンスターが獲得した Cookie の数
     */
    public int getMonsterScore() {
        return monsterScore;
    }

    /**
     * プレイヤーが死んでいるか確認します．
     *
     * @return 死んでたら true
     */
    public boolean isPlayerDead() {
        return playerDead;
    }
}
