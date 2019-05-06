package io.github.kuri_megane.Layer;

import io.github.kuri_megane.GameData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EndRollTest {

    @Test
    public void testCreateResultStringsLose() {

        EndRoll endRoll = new EndRoll();

        GameData gameData = new GameData();
        gameData.setPlayerScore(0);
        gameData.setMonsterScore(1);

        List<String> actual = endRoll.createResultStrings(gameData);

        List<String> expected = new ArrayList<String>();
        expected.add(" ____            __  __              ____                      ");
        expected.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        expected.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        expected.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        expected.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        expected.add("");
        expected.add("                              End                                ");
        expected.add("");
        expected.add("                      Name: " + gameData.getName());
        expected.add("                Your Score: " + "0");
        expected.add("             Monster Score: " + "1");
        expected.add("");
        expected.add("                         You lose...");
        expected.add("");
        expected.add("                  ");


        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }

    @Test
    public void testCreateResultStringsWin() {

        EndRoll endRoll = new EndRoll();

        GameData gameData = new GameData();
        gameData.setPlayerScore(1);
        gameData.setMonsterScore(0);

        List<String> actual = endRoll.createResultStrings(gameData);

        List<String> expected = new ArrayList<String>();
        expected.add(" ____            __  __              ____                      ");
        expected.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        expected.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        expected.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        expected.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        expected.add("");
        expected.add("                              End                                ");
        expected.add("");
        expected.add("                      Name: " + gameData.getName());
        expected.add("                Your Score: " + "1");
        expected.add("             Monster Score: " + "0");
        expected.add("");
        expected.add("                         You WIN!!");
        expected.add("");
        expected.add("                  ");


        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }

    @Test
    public void testCreateResultStringsDraw() {

        EndRoll endRoll = new EndRoll();

        GameData gameData = new GameData();
        gameData.setMonsterScore(1);
        gameData.setPlayerScore(1);

        List<String> actual = endRoll.createResultStrings(gameData);

        List<String> expected = new ArrayList<String>();
        expected.add(" ____            __  __              ____                      ");
        expected.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        expected.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        expected.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        expected.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        expected.add("");
        expected.add("                              End                                ");
        expected.add("");
        expected.add("                      Name: " + gameData.getName());
        expected.add("                Your Score: " + "1");
        expected.add("             Monster Score: " + "1");
        expected.add("");
        expected.add("                         DRAW");
        expected.add("");
        expected.add("                  ");


        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }

    @Test
    public void testCreateResultStringsDead() {

        EndRoll endRoll = new EndRoll();

        GameData gameData = new GameData();
        gameData.setDead(true);

        List<String> actual = endRoll.createResultStrings(gameData);

        List<String> expected = new ArrayList<String>();
        expected.add(" ____            __  __              ____                      ");
        expected.add("|  _ \\ __ _  ___|  \\/  | __ _ _ __  / ___| __ _ _ __ ___   ___ ");
        expected.add("| |_) / _` |/ __| |\\/| |/ _` | '_ \\| |  _ / _` | '_ ` _ \\ / _ \\");
        expected.add("|  __/ (_| | (__| |  | | (_| | | | | |_| | (_| | | | | | |  __/");
        expected.add("|_|   \\__,_|\\___|_|  |_|\\__,_|_| |_|\\____|\\__,_|_| |_| |_|\\___|");
        expected.add("");
        expected.add("                              End                                ");
        expected.add("");
        expected.add("                      Name: " + gameData.getName());
        expected.add("                Your Score: " + gameData.getPlayerScore());
        expected.add("             Monster Score: " + gameData.getMonsterScore());
        expected.add("");
        expected.add("                         DRAW");
        expected.add("");
        expected.add("                  You Dead... GAME OUT!!");


        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }

    }
}
