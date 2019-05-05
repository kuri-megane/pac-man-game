package io.github.kuri_megane;

import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Logger;

public class Controller implements NativeKeyListener {

    private GameMap gameMap;
    private PacMan pacMan;
    private Logger logger = Logger.getLogger(Controller.class.getName());

    public Controller(GameMap gameMap, PacMan pacMan) {
        this.gameMap = gameMap;
        this.pacMan = pacMan;
    }

    // キーが押された
    public void nativeKeyPressed(NativeKeyEvent e) {

        logger.info(Integer.toString(e.getRawCode()));

        // 左矢印キー
        if (e.getRawCode() == 123) {
            if (gameMap.get(pacMan.getRow(), pacMan.getCol() - 1).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow(), pacMan.getCol() - 1));
                return;
            }
        }

        // 右矢印キー
        if (e.getRawCode() == 124) {
            if (gameMap.get(pacMan.getRow(), pacMan.getCol() + 1).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow(), pacMan.getCol() + 1));
                return;
            }
        }

        // 下矢印キー
        if (e.getRawCode() == 125) {
            if (gameMap.get(pacMan.getRow() + 1, pacMan.getCol()).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow() + 1, pacMan.getCol()));
                return;
            }
        }

        // 上矢印キー
        if (e.getRawCode() == 126) {
            if (gameMap.get(pacMan.getRow() - 1, pacMan.getCol()).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow() - 1, pacMan.getCol()));
                return;
            }
        }

        pacMan.failToMove();
    }

    // キーが離された
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    // キーがタイプされた
    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
