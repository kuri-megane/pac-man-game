package io.github.kuri_megane.Layer;

import io.github.kuri_megane.Objects.GameMap;
import io.github.kuri_megane.Objects.GameObjects;
import jline.Terminal;
import jline.TerminalFactory;
import jline.console.ConsoleReader;

import java.io.IOException;

public class PlayScreen implements BackLayer {

    private int consoleHeight = 0;
    private int consoleWidth = 0;
    private GameMap gameMap;
    private ConsoleReader console;


    public PlayScreen(GameMap gameMap) {
        this.gameMap = gameMap;

        try {
            console = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void getConsoleSize() {
        Terminal terminal = TerminalFactory.get();
        consoleHeight = terminal.getHeight();
        consoleWidth = terminal.getWidth();
    }

    public void display() {

        try {

            // オブジェクトの表示
            // XXX: ここあとでもう少しきれいに
            // TODO: コンソールのサイズに合わせて
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 17; col++) {
                    GameObjects gameObjects = gameMap.get(row, col);
                    System.out.printf(gameObjects.getChar());
                }
                System.out.printf("%n");
            }
            console.flush();

            // スクリーンクリア
            console.clearScreen();
            console.flush();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
