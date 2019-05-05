package io.github.kuri_megane.Layer;

import jline.console.ConsoleReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartMenu extends Display {

    private static final List<String> title = new ArrayList<String>();

    public StartMenu() {
        super();
    }

    /**
     * タイトル文字列の整形
     *
     * @return タイトル文字列
     */
    public List<String> createTitle() {

        // XXX: ここにベタ書きするの良くない
        title.add(" ____            __  __              ____                      ");
        title.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        title.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        title.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        title.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        title.add("%n");
        title.add("                           Ready...?                                ");

        return title;
    }

    /**
     * ユーザーの名前を入力してもらう
     *
     * @return 入力された文字列
     */
    public String inputName() {

        String inputName = "";
        ConsoleReader console = null;

        try {
            console = new ConsoleReader();
            console.setPrompt("Your Name > ");
            inputName = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(inputName);

        return inputName;
    }
}
