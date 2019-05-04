package io.github.kuri_megane;

import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.PacMan;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Controller implements NativeKeyListener {

    private GameMap gameMap;
    private PacMan pacMan;

    public Controller(GameMap gameMap, PacMan pacMan) {
        this.gameMap = gameMap;
        this.pacMan = pacMan;
    }

    // キーが押された
    public void nativeKeyPressed(NativeKeyEvent e) {

        // 右矢印キー
        if (e.getRawCode() == 124) {

            if (gameMap.get(pacMan.getRow(), pacMan.getCol() + 1).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow(), pacMan.getCol() + 1));
            }

            System.out.println("右");

        }

        // 左矢印キー
        if (e.getRawCode() == 123) {

           if (gameMap.get(pacMan.getRow(), pacMan.getCol() - 1).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow(), pacMan.getCol() - 1));
            }

            System.out.println("左");

        }

        // 下矢印キー
        if (e.getRawCode() == 125) {

            if (gameMap.get(pacMan.getRow() + 1, pacMan.getCol()).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow() + 1, pacMan.getCol()));
            }

            System.out.println("下");

        }

        // 上矢印キー
        if (e.getRawCode() == 126) {

            if (gameMap.get(pacMan.getRow() - 1, pacMan.getCol()).isGo()) {
                gameMap.move(pacMan, new Point(pacMan.getRow() - 1, pacMan.getCol()));
            }

            System.out.println("上");

        }

        System.out.println(e.paramString());
    }

    // キーが離された
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println(e.paramString());
    }

    // キーがタイプされた
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println(e.paramString());
    }
}
