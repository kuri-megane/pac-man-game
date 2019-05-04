package io.github.kuri_megane.Layer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

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

    Object getConsoleHeightByReflection(PlayScreen obj) throws Exception {
        Field field = PlayScreen.class.getDeclaredField("consoleHeight");
        field.setAccessible(true);
        return field.get(obj);
    }

    Object getConsoleWidthByReflection(PlayScreen obj) throws Exception {
        Field field = PlayScreen.class.getDeclaredField("consoleWidth");
        field.setAccessible(true);
        return field.get(obj);
    }

    @Test
    public void testGetConsoleSize() throws Exception {

        PlayScreen playScreen = new PlayScreen();

        playScreen.getConsoleSize();
        int resultHeight = (Integer) getConsoleHeightByReflection(playScreen);
        int resultWidth = (Integer) getConsoleWidthByReflection(playScreen);

        // コンソールの高さは10以上
        assertThat(resultHeight, is(greaterThan(10)));

        // コンソールの高さは30以上
        assertThat(resultWidth, is(greaterThan(30)));

    }

    @Test
    public void testDisplayGameMap() {

        PlayScreen playScreen = new PlayScreen();
        String expectation = "You say good bye!%nI say hello!%n";
        playScreen.display(expectation);

        String[] result = out.toString().split(System.lineSeparator());

        assertThat(result[0], is("You say good bye!"));
        assertThat(result[1], is("I say hello!"));
    }

}
