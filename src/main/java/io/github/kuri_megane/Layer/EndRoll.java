package io.github.kuri_megane.Layer;

import io.github.kuri_megane.GamaData;
import jline.Terminal;
import jline.TerminalFactory;
import jline.console.ConsoleReader;

import java.io.IOException;

public class EndRoll implements BackLayer {

    // XXX: ここにベタ書きするの良くない
    private static final String strDisplay =
            " ____            __  __              ____                      %n"
                    + "|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ %n"
                    + "| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\%n"
                    + "|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/%n"
                    + "|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|%n"
                    + "%n"
                    + "                              END                                %n";
    private int consoleHeight = 0;
    private int consoleWidth = 0;
    private ConsoleReader console;
    private String strPlayerResult = "";

    public EndRoll() {
        try {
            console = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * コンソールサイズを取得します．
     */
    public void getConsoleSize() {
        Terminal terminal = TerminalFactory.get();
        consoleHeight = terminal.getHeight();
        consoleWidth = terminal.getWidth();
    }

    public void createPlayerResult(GamaData gamaData) {
        strPlayerResult =
                "         "
                        + "Player Name: " + gamaData.getName()
                        + "   Score: " + gamaData.getScore();
    }

    /**
     * エンドロールの描画
     *
     * @param strings カスタムで先に表示する文字列
     */
    public void display(String strings) {

        // クリア
        try {
            console.clearScreen();
            console.flush();
        } catch (IOException e) {
            e.getMessage();
        }

        // 表示
        System.out.printf(strDisplay);
        System.out.printf(strPlayerResult);
        System.out.println(strings);

        // 一時スリープ
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
