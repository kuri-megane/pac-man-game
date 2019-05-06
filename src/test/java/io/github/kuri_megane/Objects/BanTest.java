package io.github.kuri_megane.Objects;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BanTest {

    @Test
    public void testGetChar() {
        Ban ban = new Ban();

        // 色を示すコードが含まれる
        assertThat(ban.getChar(), is("\u001B[00;41m \u001B[00m"));
    }

    @Test
    public void testIsGo() {
        Ban ban = new Ban();
        assertThat(ban.isGo(), is(false));
    }

    @Test
    public void testGetKey() {
        Ban ban = new Ban();
        assertThat(ban.getKey(), is("b"));
    }
}

