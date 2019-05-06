package io.github.kuri_megane.Objects;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CookieTest {

    @Test
    public void testGetChar() {
        Cookie cookie = new Cookie();
        assertThat(cookie.getChar(), is("★"));
    }

    @Test
    public void testIsGo() {
        Cookie cookie = new Cookie();
        assertThat(cookie.isGo(), is(true));
    }

    @Test
    public void testGetKey() {
        Cookie cookie = new Cookie();
        assertThat(cookie.getKey(), is("c"));
    }
}
