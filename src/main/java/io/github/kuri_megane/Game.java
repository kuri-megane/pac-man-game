package io.github.kuri_megane;

import io.github.kuri_megane.Layer.PlayScreen;
import io.github.kuri_megane.Objects.GameMap;

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
        playScreen = new PlayScreen(gameMap);

        while (gameMap.isProceed()) {
            playScreen.display();
        }
    }

}
