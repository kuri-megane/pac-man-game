package io.github.kuri_megane.Objects.Color;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RedTest {

    @Test
    public void testColoringChar() {

        String input = "hoge";

        Red red = new Red(input);
        String actual = red.coloringChar();

        String expected = "\u001B[00;31mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }

    @Test
    public void testColoringBack() {

        String input = "hoge";

        Red red = new Red(input);
        String actual = red.coloringBack();

        String expected = "\u001B[00;41mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }
}
