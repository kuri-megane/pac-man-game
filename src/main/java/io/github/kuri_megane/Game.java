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

        // パックマン配置
        PacMan pacMan = new PacMan(1, 1);        // XXX:(1,1):意味無し, TODO:Pointクラスの修正
        gameMap.move(pacMan, new Point(1,2));

        // モンスター配置
        Monster monster = new Monster(3, 1);    // XXX:(3,1):意味無し, TODO:Pointクラスの修正
        gameMap.move(monster, new Point(3,2));

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
        while (gameMap.isProceed()){

            // Monster の移動
            if (gameMap.get(monster.next().getRow(), monster.next().getCol()).isGo()) {
                gameMap.move(monster, monster.next());
            }

            // 描画
            playScreen.display(gameMap.createDisplayStrings());

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

    public int getScoreOfThisGame(){
        return scoreOfThisGame;
    }
}
