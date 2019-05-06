package io.github.kuri_megane;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PointTest {

    @Test
    public void testGetRow() throws NoSuchFieldException, IllegalAccessException {

        Point point = new Point(0, 1);

        Field field = Point.class.getDeclaredField("row");
        field.setAccessible(true);

        int actual = (Integer) field.get(point);
        assertThat(0, is(actual));

    }

    @Test
    public void testGetCol() throws NoSuchFieldException, IllegalAccessException {

        Point point = new Point(0, 1);

        Field field = Point.class.getDeclaredField("col");
        field.setAccessible(true);

        int actual = (Integer) field.get(point);
        assertThat(1, is(actual));

    }

    @Test
    public void testSetRow() throws NoSuchFieldException, IllegalAccessException {

        Point point = new Point(0, 1);
        point.setRow(2);

        Field field = Point.class.getDeclaredField("row");
        field.setAccessible(true);

        int actual = (Integer) field.get(point);
        assertThat(2, is(actual));

    }

    @Test
    public void testSetCol() throws NoSuchFieldException, IllegalAccessException {

        Point point = new Point(0, 1);
        point.setCol(3);

        Field field = Point.class.getDeclaredField("col");
        field.setAccessible(true);

        int actual = (Integer) field.get(point);
        assertThat(3, is(actual));

    }
}
