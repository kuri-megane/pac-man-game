package io.github.kuri_megane.Objects;

public interface MovingObjects {

    int getRow();

    int getCol();

    void setRow(int row);

    void setCol(int col);

    void addScore();

    int getScore();

    void failToMove();

}
