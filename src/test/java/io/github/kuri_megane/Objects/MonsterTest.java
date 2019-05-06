package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MonsterTest {

    @Test
    public void testGetChar() {
        Monster monster = new Monster(1, 1);

        // 色を付けて出力しているので色のコードが入る
        assertThat(monster.getChar(), is("\u001B[00;35m×\u001B[00m"));
    }

    @Test
    public void testIsGo() {
        Monster monster = new Monster(1, 1);
        assertThat(monster.isGo(), is(false));
    }

    @Test
    public void testGetKey() {
        Monster monster = new Monster(1, 1);
        assertThat(monster.getKey(), is("m"));
    }

    @Test
    public void testNext() {
        // TODO: テストコードを書く
    }

    @Test
    public void testNextRandom() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Monster monster = new Monster(1, 1);

        List<Point> candidates = new ArrayList<Point>();
        candidates.add(new Point(0, 0));
        candidates.add(new Point(0, 1));
        candidates.add(new Point(0, 2));
        candidates.add(new Point(0, 3));

        Method method = Monster.class.getDeclaredMethod("nextRandom", List.class);
        method.setAccessible(true);
        Point actual = (Point) method.invoke(monster, candidates);

        // TODO: テストコードを書く

    }

    @Test
    public void testChasePacMan() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Monster monster = new Monster(1, 1);

        PacMan pacMan = new PacMan(0, 0);
        List<Point> candidates = new ArrayList<Point>();
        candidates.add(new Point(0, 0));
        candidates.add(new Point(0, 1));
        candidates.add(new Point(0, 2));
        candidates.add(new Point(0, 3));

        Method method = Monster.class.getDeclaredMethod("nextChasePacMan", List.class, PacMan.class);
        method.setAccessible(true);
        Point actual = (Point) method.invoke(monster, candidates, pacMan);

        // TODO: テストコードを書く
    }

    @Test
    public void testCalcDistance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Monster monster = new Monster(1, 1);

        PacMan pacMan = new PacMan(0, 0);
        Point p = new Point(1, 1);

        Method method = Monster.class.getDeclaredMethod("calcDistance", PacMan.class, Point.class);
        method.setAccessible(true);
        Double actual = (Double) method.invoke(monster, pacMan, p);

        double expected = 3.0;

        assertThat(expected, is(actual));

    }

    @Test
    public void testAddScore() throws NoSuchFieldException, IllegalAccessException {

        Monster monster = new Monster(1, 1);

        Field field = Monster.class.getDeclaredField("score");
        field.setAccessible(true);

        // 得点を付与するごとに+1
        int actual = (Integer) field.get(monster);
        assertThat(0, is(actual));

        monster.addScore();
        actual = (Integer) field.get(monster);
        assertThat(1, is(actual));

        monster.addScore();
        actual = (Integer) field.get(monster);
        assertThat(2, is(actual));

    }

    @Test
    public void testGetScore() throws NoSuchFieldException, IllegalAccessException {

        Monster monster = new Monster(1, 1);

        Field field = Monster.class.getDeclaredField("score");
        field.setAccessible(true);

        // 最初は 0
        int actual = (Integer) field.get(monster);
        assertThat(0, is(actual));

        // 付与すれば 1
        monster.addScore();
        actual = (Integer) field.get(monster);
        assertThat(1, is(actual));

    }

    @Test
    public void testSetBeforePoint() throws NoSuchFieldException, IllegalAccessException {

        Monster monster = new Monster(1, 1);
        monster.setBeforePoint();

        Field field = Monster.class.getDeclaredField("before");
        field.setAccessible(true);
        Point actual = (Point) field.get(monster);

        // 初期状態では Monster(1,1) と等しい
        Point expected = new Point(1, 1);

        assertThat(actual.getCol(), is(expected.getCol()));
        assertThat(actual.getRow(), is(expected.getRow()));

        // 新しい座標をセットすると
        monster.setRow(2);
        monster.setCol(2);

        // before は変わらないが
        actual = (Point) field.get(monster);
        assertThat(actual.getCol(), is(expected.getCol()));
        assertThat(actual.getRow(), is(expected.getRow()));

        // setBeforePoint() を実行すると
        monster.setBeforePoint();
        actual = (Point) field.get(monster);
        assertThat(actual.getCol(), is(2));
        assertThat(actual.getRow(), is(2));

    }

}
