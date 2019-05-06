package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PacManTest {

    @Test
    public void testGetChar() {
        PacMan pacMan = new PacMan(1, 1);

        // 色を付けて出力しているので色のコードが入る
        assertThat(pacMan.getChar(), is("\u001B[00;32m●\u001B[00m"));
    }

    @Test
    public void testIsGo() {
        PacMan pacMan = new PacMan(1, 1);
        assertThat(pacMan.isGo(), is(true));
    }

    @Test
    public void testGetKey() {
        PacMan pacMan = new PacMan(1, 1);
        assertThat(pacMan.getKey(), is("p"));
    }

    @Test
    public void testAddScore() throws NoSuchFieldException, IllegalAccessException {

        PacMan pacMan = new PacMan(1, 1);

        Field field = PacMan.class.getDeclaredField("score");
        field.setAccessible(true);

        // 得点を付与するごとに+1
        int actual = (Integer) field.get(pacMan);
        assertThat(0, is(actual));

        pacMan.addScore();
        actual = (Integer) field.get(pacMan);
        assertThat(1, is(actual));

        pacMan.addScore();
        actual = (Integer) field.get(pacMan);
        assertThat(2, is(actual));

    }

    @Test
    public void testGetScore() throws NoSuchFieldException, IllegalAccessException {

        PacMan pacMan = new PacMan(1, 1);

        Field field = PacMan.class.getDeclaredField("score");
        field.setAccessible(true);

        // 最初は 0
        int actual = (Integer) field.get(pacMan);
        assertThat(0, is(actual));

        // 付与すれば 1
        pacMan.addScore();
        actual = (Integer) field.get(pacMan);
        assertThat(1, is(actual));

    }

    @Test
    public void testSetBeforePoint() throws NoSuchFieldException, IllegalAccessException {

        PacMan pacMan = new PacMan(1, 1);
        pacMan.setBeforePoint();

        Field field = PacMan.class.getDeclaredField("before");
        field.setAccessible(true);
        Point actual = (Point) field.get(pacMan);

        // 初期状態では PacMan(1,1) と等しい
        Point expected = new Point(1, 1);

        assertThat(actual.getCol(), is(expected.getCol()));
        assertThat(actual.getRow(), is(expected.getRow()));

        // 新しい座標をセットすると
        pacMan.setRow(2);
        pacMan.setCol(2);

        // before は変わらないが
        actual = (Point) field.get(pacMan);
        assertThat(actual.getCol(), is(expected.getCol()));
        assertThat(actual.getRow(), is(expected.getRow()));

        // setBeforePoint() を実行すると
        pacMan.setBeforePoint();
        actual = (Point) field.get(pacMan);
        assertThat(actual.getCol(), is(2));
        assertThat(actual.getRow(), is(2));

    }
}
