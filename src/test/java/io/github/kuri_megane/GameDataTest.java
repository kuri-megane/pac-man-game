package io.github.kuri_megane;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameDataTest {

    @Test
    public void testGetName() {

        GameData gameData = new GameData();

        String expected = "hoge";
        gameData.setName(expected);

        String actual = gameData.getName();
        assertThat(expected, is(actual));

    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {

        GameData gameData = new GameData();

        String expected = "hoge";
        gameData.setName(expected);

        Field field = GameData.class.getDeclaredField("name");
        field.setAccessible(true);

        String actual = (String) field.get(gameData);
        assertThat(expected, is(actual));

    }

    @Test
    public void testGetPlayerScore() {

        GameData gameData = new GameData();

        int expected = 0;
        int actual = gameData.getPlayerScore();
        assertThat(expected, is(actual));

    }

    @Test
    public void testSetPlayerScore() throws NoSuchFieldException, IllegalAccessException {

        GameData gameData = new GameData();

        int expected = 10;
        gameData.setPlayerScore(expected);

        Field field = GameData.class.getDeclaredField("playerScore");
        field.setAccessible(true);

        int actual = (Integer) field.get(gameData);
        assertThat(expected, is(actual));

    }

    @Test
    public void testGetMonsterScore() {

        GameData gameData = new GameData();

        int expected = 0;
        int actual = gameData.getMonsterScore();
        assertThat(expected, is(actual));

    }

    @Test
    public void testSetMonsterScore() throws NoSuchFieldException, IllegalAccessException {

        GameData gameData = new GameData();

        int expected = 10;
        gameData.setMonsterScore(expected);

        Field field = GameData.class.getDeclaredField("monsterScore");
        field.setAccessible(true);

        int actual = (Integer) field.get(gameData);
        assertThat(expected, is(actual));
    }

    @Test
    public void testIsDead() {

        GameData gameData = new GameData();

        boolean expected = false;
        boolean actual = gameData.isDead();
        assertThat(expected, is(actual));

    }

    @Test
    public void testSetDead() throws NoSuchFieldException, IllegalAccessException {

    }
}
