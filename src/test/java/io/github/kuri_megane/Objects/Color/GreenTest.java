package io.github.kuri_megane.Objects.Color;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreenTest {

    @Test
    public void testColoringChar() {

        String input = "hoge";

        Green green = new Green(input);
        String actual = green.coloringChar();

        String expected = "\u001B[00;32mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }

    @Test
    public void testColoringBack() {

        String input = "hoge";

        Green green = new Green(input);
        String actual = green.coloringBack();

        String expected = "\u001B[00;42mhoge\u001B[00m";

        assertThat(actual, is(expected));

    }
}
