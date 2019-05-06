package io.github.kuri_megane.Objects;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WallTest {

    @Test
    public void testGetChar() {
        Wall wall = new Wall();
        
        // 色を示すコードが含まれる
        assertThat(wall.getChar(), is("\u001B[00;44m \u001B[00m"));
    }

    @Test
    public void testIsGo() {
        Wall wall = new Wall();
        assertThat(wall.isGo(), is(false));
    }

    @Test
    public void testGetKey() {
        Wall wall = new Wall();
        assertThat(wall.getKey(), is("w"));
    }
}
