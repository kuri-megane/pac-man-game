package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.util.Random;

public class Monster extends Point implements GameObjects, MovingObjects {

    private static final String displayChar = "×";
    private static final boolean goFlag = false;
    private static final String key = "m";

    public Monster(int row, int col) {
        super(row, col);
    }

    public String getChar() {
        return displayChar;
    }

    public boolean isGo() {
        return goFlag;
    }

    public String getKey() {
        return key;
    }

    public Point next() {

        Point after = new Point(0, 0);
        Random random = new Random();

        // 約半分の確率で横にずらす
        if (random.nextBoolean()) {
            after.setRow(getRow() + random.nextInt(3) - 1);
            after.setCol(getCol());
            return after;
        }

        // 縦にずらす
        after.setRow(getRow());
        after.setCol(getCol() + random.nextInt(3) - 1);
        return after;
    }
}
