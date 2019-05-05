package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameMapTest {

    private String[][] strGameMapTest = new String[][]{
            {"w", "c", "n", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"w", "c", "n", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"w", "c", "n", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"w", "c", "n", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"w", "c", "n", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
    };

    Object getNumOfObjectsByReflection(GameMap obj) throws Exception {
        Field field = GameMap.class.getDeclaredField("numOfObjects");
        field.setAccessible(true);
        return field.get(obj);
    }

    Object getStrGameMapByReflection(GameMap obj) throws Exception {
        Field field = GameMap.class.getDeclaredField("strGameMap");
        field.setAccessible(true);
        return field.get(obj);
    }

    Object getGameMapByReflection(GameMap obj) throws Exception {
        Field field = GameMap.class.getDeclaredField("gameMap");
        field.setAccessible(true);
        return field.get(obj);
    }

    @Test
    public void testSetUpDefault() throws Exception {

        String[][] expected = new String[][]{
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
                {"w", "n", "n", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "w"},
                {"w", "c", "w", "w", "w", "w", "w", "c", "w", "w", "w", "w", "w", "w", "w", "c", "w"},
                {"w", "n", "n", "c", "c", "c", "c", "c", "c", "c", "c", "n", "c", "c", "c", "c", "w"},
                {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}
        };

        GameMap gameMap = new GameMap();
        // NOTICE: ここで例外発生の可能性あり
        String[][] actual = (String[][]) getStrGameMapByReflection(gameMap);

        assertThat(expected, is(actual));

    }

    @Test
    public void testSetUpCustom() throws Exception {

        // 自分で定義したものでもいい
        GameMap gameMap = new GameMap(strGameMapTest);
        // NOTICE: ここで例外発生の可能性あり
        String[][] actual = (String[][]) getStrGameMapByReflection(gameMap);

        assertThat(strGameMapTest, is(actual));

    }

    @Test(expected = NullPointerException.class)
    public void testSetUpFailed() throws Exception {

        // 大きさが違うとだめ
        String[][] expected = new String[][]{
                {"a", "a", "a"},
                {"a", "a", "a"},
                {"a", "a", "a"}
        };
        GameMap gameMap = new GameMap(expected);

        // ここで例外発生の可能性あり
        String[][] actual = (String[][]) getStrGameMapByReflection(gameMap);

        assertThat(expected, is(actual));

    }

    @Test
    public void testConvert() throws Exception {

        GameMap gameMap = new GameMap(strGameMapTest);

        // ここで例外発生の可能性あり
        GameObjects[][] actual = (GameObjects[][]) getGameMapByReflection(gameMap);

        // XXX: 見にくい
        GameObjects[][] expected = new GameObjects[][]{
                {new Wall(), new Cookie(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(),},
                {new Wall(), new Cookie(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(),},
                {new Wall(), new Cookie(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(),},
                {new Wall(), new Cookie(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(),},
                {new Wall(), new Cookie(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(), new Nothing(), new Nothing(), new Nothing(),
                        new Nothing(), new Nothing(),},
        };

        for (int row = 0; row < expected.length; row++) {
            for (int col = 0; col < expected[row].length; col++) {
                assertThat(
                        expected[row][col],
                        is(instanceOf(actual[row][col].getClass()))
                );
            }
        }
    }

    @Test
    public void testCount() throws Exception {

        GameMap gameMap = new GameMap();

        // ここで例外発生の可能性あり
        Map<String, Integer> actual = (Map<String, Integer>) getNumOfObjectsByReflection(gameMap);

        assertThat(actual, hasEntry("w", 52));
        assertThat(actual, hasEntry("c", 28));
        assertThat(actual, hasEntry("n", 5));

    }

    @Test
    public void testGet() {

        GameMap gameMap = new GameMap();
        assertThat(gameMap.get(0, 0), Matchers.<GameObjects>instanceOf(Wall.class));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetFailed() {

        GameMap gameMap = new GameMap();

        // 無効な座標を指定するとエラー
        assertThat(gameMap.get(-1, 0), any(Object.class));
        assertThat(gameMap.get(5, 0), any(Object.class));
        assertThat(gameMap.get(0, 17), any(Object.class));

    }

    @Test
    public void testMove() {

        GameMap gameMap = new GameMap(strGameMapTest);

        // 移動前
        PacMan pacMan = new PacMan(4,1);

        // 移動後
        gameMap.move(pacMan, new Point(4,2));

        // 移動前は Nothing オブジェクトに
        assertThat(gameMap.get(4, 1), Matchers.<GameObjects>instanceOf(Nothing.class));

        // 移動後は PacMan が配置される
        assertThat(gameMap.get(4, 2), Matchers.<GameObjects>instanceOf(PacMan.class));

    }

    @Test
    public void testRewriteFail() {

        GameMap gameMap = new GameMap(strGameMapTest);
        PacMan pacMan = new PacMan(1,1);

        // Wall オブジェクトは書き換え不可
        gameMap.move(pacMan, new Point(0,1));
        assertThat(gameMap.get(0, 0), Matchers.<GameObjects>instanceOf(Wall.class));

    }

    @Test
    public void testIsProceedTrue() {

        GameMap gameMap = new GameMap();
        assertThat(gameMap.isProceed(), is(true));

    }

    @Test
    public void testIsProceedFalse() {

        GameMap gameMap = new GameMap(strGameMapTest);
        PacMan pacMan = new PacMan(0,2);

        gameMap.move(pacMan, new Point(0,1));
        gameMap.move(pacMan, new Point(1,1));
        gameMap.move(pacMan, new Point(2,1));
        gameMap.move(pacMan, new Point(3,1));
        gameMap.move(pacMan, new Point(4,1));

        assertThat(gameMap.isProceed(), is(false));

    }

    @Test
    public void testCreateDisplayStrings() {

        GameMap gameMap = new GameMap(strGameMapTest);
        List<String> actual = gameMap.createDisplayStrings();
        List<String> expected = new ArrayList<String>();

        expected.add("\u001B[00;44m \u001B[00m★               ");
        expected.add("\u001B[00;44m \u001B[00m★               ");
        expected.add("\u001B[00;44m \u001B[00m★               ");
        expected.add("\u001B[00;44m \u001B[00m★               ");
        expected.add("\u001B[00;44m \u001B[00m★               ");

        assertThat(actual, is(expected));

    }
}
