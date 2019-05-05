package io.github.kuri_megane.Layer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayScreenTest {

    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out, true));
    }

    @After
    public void tearDown() {
        System.setOut(stdout);
    }

    @Test
    public void testDisplayGameMap() {

        PlayScreen playScreen = new PlayScreen();
        List<String> input = new ArrayList<String>();
        input.add("You say good bye!");
        input.add("I say hello!");

        playScreen.display(input);

        String[] result = out.toString().split(System.lineSeparator());

        assertThat(result[0], is("\u001B[H\u001B[JYou say good bye!"));
        assertThat(result[1], is("I say hello!"));
    }

}
