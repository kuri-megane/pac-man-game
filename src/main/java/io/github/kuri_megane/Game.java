package io.github.kuri_megane;

import io.github.kuri_megane.Layer.PlayScreen;
import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.Monster;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;

public class Game {

    private GameMap gameMap;
    private PlayScreen playScreen;

    public Game() {
    }

    /**
     * 1ゲームの開始
     */
    public void run() {

        gameMap = new GameMap();
        playScreen = new PlayScreen();

        // パックマン配置
        PacMan pacMan = new PacMan(1,1);
        gameMap.move(pacMan, new Point(1,2));

        // モンスター配置
        Monster monster = new Monster(3, 1);
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

        while (gameMap.isProceed()){

            playScreen.display(gameMap.createDisplayStrings());

        }

    }
}
