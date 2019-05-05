package io.github.kuri_megane.Layer;

import jline.Terminal;
import jline.TerminalFactory;
import jline.console.ConsoleReader;

import java.io.IOException;
import java.util.List;

public class Display extends Thread {

    private int consoleHeight = 0;
    private int consoleWidth = 0;
    private ConsoleReader console;

    public Display() {
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

    /**
     * ゲームのプレイ画面 (つまり ゲームマップ) の描画
     *
     * @param lines 描画する文字列
     */
    public void display(List<String> lines) {

        // 渡された描画文字列の縦横幅を取得
        int stringsHeight = lines.size();
        int stringsWidth = 0;
        for (String s : lines) {

            // 文字着色コードを削除
            s = s.replaceAll("\\u001B\\[00;[3,4][0-9]m", "");
            s = s.replaceAll("\\u001B\\[00", "");

            if (stringsWidth < s.length()) {
                stringsWidth = s.length();
            }
        }

        // コンソール画面の大きさに合うように余白を計算
        StringBuilder spaceHeight = new StringBuilder();
        StringBuilder spaceWidth = new StringBuilder();
        for (int s = 0; s < (consoleHeight - stringsHeight) / 2 - 1; s++) {
            spaceHeight.append("%n");
        }
        for (int s = 0; s < (consoleWidth - stringsWidth) / 2 - 1; s++) {
            spaceWidth.append(" ");
        }

        // クリア
        try {
            console.clearScreen();
            console.flush();
        } catch (IOException e) {
            e.getMessage();
        }

        // 表示
        System.out.printf(spaceHeight.toString());
        for (String line : lines) {
            System.out.printf(spaceWidth.toString() + line + spaceWidth.toString() + "%n");
        }
        System.out.printf(spaceHeight.toString());

        // 一時スリープ
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
