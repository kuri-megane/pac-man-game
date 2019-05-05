package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.util.Random;

public class Monster extends Point implements GameObjects, MovingObjects {

    private static final String displayChar = "×";
    private static final boolean goFlag = false;
    private static final String key = "m";
    private int score = 0;

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

        // 最大で8近傍にずれる
        after.setRow(getRow() + random.nextInt(3) - 1);
        after.setCol(getCol() + random.nextInt(3) - 1);

        return after;
    }

    public void addScore(){
        score++;
    }

    public int getScore(){
        return score;
    }
}
