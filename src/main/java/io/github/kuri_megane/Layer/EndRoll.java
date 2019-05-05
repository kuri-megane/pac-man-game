package io.github.kuri_megane.Layer;

import io.github.kuri_megane.GamaData;

import java.util.ArrayList;
import java.util.List;

public class EndRoll extends Display {

    private static final List<String> title = new ArrayList<String>();

    public EndRoll() {
        super();
    }

    /**
     * タイトル文字列の整形
     *
     * @return タイトル文字列
     */
    public List<String> createResultStrings(GamaData gamaData) {

        // XXX: ここにベタ書きするの良くない
        title.add(" ____            __  __              ____                      ");
        title.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        title.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        title.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        title.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        title.add("");
        title.add("                              End                                ");
        title.add("");
        title.add("                      Name: " + gamaData.getName());
        title.add("                     Score: " + gamaData.getScore());

        return title;
    }
}
