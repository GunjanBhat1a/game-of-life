package com.tw.game.of.life.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {

     final int xCoordinate;
   final int yCoordinate;
    private final int NO_OF_DIRECTIONS = 8;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public List<Cell> getNeighbours() {
        int xCoordinate = this.xCoordinate;
        int yCoordinate = this.yCoordinate;

        int dxForNeighbours[] = {0, 0, -1, 1, -1, -1, 1, 1};
        int dyForNeighbours[] = {-1, 1, 0, 0, 1, -1, -1, 1};

        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < NO_OF_DIRECTIONS; i++) {
            int neighbourXCoordinate = xCoordinate + dxForNeighbours[i];
            int neighbourYCoordinate = yCoordinate + dyForNeighbours[i];

            neighbours.add(new Cell(neighbourXCoordinate, neighbourYCoordinate));
        }

        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate && yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
