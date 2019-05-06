package io.github.kuri_megane.Objects;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NothingTest {

    @Test
    public void testGetChar() {
        Nothing nothing = new Nothing();
        assertThat(nothing.getChar(), is(" "));
    }

    @Test
    public void testIsGo() {
        Nothing nothing = new Nothing();
        assertThat(nothing.isGo(), is(true));
    }

    @Test
    public void testGetKey() {
        Nothing nothing = new Nothing();
        assertThat(nothing.getKey(), is("n"));
    }
}
