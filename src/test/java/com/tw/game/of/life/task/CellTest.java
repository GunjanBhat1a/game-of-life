package com.tw.game.of.life.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {

    @Test
    void shouldReturnEightNeighboursOfCell() {
        Cell cell = new Cell(1, 2);

        List<Cell> expectedNeighbours = new ArrayList<>();

        expectedNeighbours.add(new Cell(1, 1));
        expectedNeighbours.add(new Cell(1, 3));
        expectedNeighbours.add(new Cell(0, 2));
        expectedNeighbours.add(new Cell(2, 2));
        expectedNeighbours.add(new Cell(0, 3));
        expectedNeighbours.add(new Cell(0, 1));
        expectedNeighbours.add(new Cell(2, 1));
        expectedNeighbours.add(new Cell(2, 3));

        assertTrue(cell.getNeighbours().containsAll(expectedNeighbours));
    }
}
