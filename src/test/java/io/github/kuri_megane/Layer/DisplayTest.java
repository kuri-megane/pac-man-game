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

public class DisplayTest {

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

    Object getConsoleHeightByReflection(Display obj) throws Exception {
        Field field = Display.class.getDeclaredField("consoleHeight");
        field.setAccessible(true);
        return field.get(obj);
    }

    Object getConsoleWidthByReflection(Display obj) throws Exception {
        Field field = Display.class.getDeclaredField("consoleWidth");
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
}
