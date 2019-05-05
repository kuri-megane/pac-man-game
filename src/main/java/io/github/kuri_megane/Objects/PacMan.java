package io.github.kuri_megane.Objects;

import io.github.kuri_megane.Point;

import java.awt.*;

public class PacMan extends Point implements GameObjects, MovingObjects {

    private static final String defaultChar = "●";
    private static final boolean goFlag = true;
    private static final String key = "p";
    private int score = 0;

    public PacMan(int row, int col) {
        super(row, col);
    }

    public String getChar() {
        return defaultChar;
    }

    public boolean isGo() {
        return goFlag;
    }

    public String getKey() {
        return key;
    }

    public void addScore(){
        score++;
    }

    public int getScore(){
        return score;
    }

    /**
     * 移動先に移動できなかったときに使う
     */
    public void failToMove() {
        Toolkit.getDefaultToolkit().beep();
    }
}
