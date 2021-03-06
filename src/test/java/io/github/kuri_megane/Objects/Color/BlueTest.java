package io.github.kuri_megane.Objects.Color;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlueTest {

    @Test
    public void testColoringChar() {

        String input = "hoge";

        Blue blue = new Blue(input);
        String actual = blue.coloringChar();

        String expected = "\u001B[00;34mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }

    @Test
    public void testColoringBack() {

        String input = "hoge";

        Blue blue = new Blue(input);
        String actual = blue.coloringBack();

        String expected = "\u001B[00;44mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }
}
