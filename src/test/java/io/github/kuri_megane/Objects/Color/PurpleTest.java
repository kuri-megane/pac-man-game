package io.github.kuri_megane.Objects.Color;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurpleTest {

    @Test
    public void testColoringChar() {

        String input = "hoge";

        Purple purple = new Purple(input);
        String actual = purple.coloringChar();

        String expected = "\u001B[00;35mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }

    @Test
    public void testColoringBack() {

        String input = "hoge";

        Purple purple = new Purple(input);
        String actual = purple.coloringBack();

        String expected = "\u001B[00;45mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }
}
