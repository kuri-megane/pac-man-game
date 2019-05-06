package io.github.kuri_megane.Layer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartMenuTest {

    @Test
    public void testCreateTitle() {

        StartMenu startMenu = new StartMenu();

        List<String> actual = startMenu.createTitle();

        List<String> expected = new ArrayList<String>();
        expected.add(" ____            __  __              ____                      ");
        expected.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        expected.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        expected.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        expected.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        expected.add("%n");
        expected.add("                           Ready...?                                ");

        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }


    @Test
    public void testInputName() {
        // TODO: テストを追加する
    }
}
