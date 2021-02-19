package com.tw.game.of.life.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {

    @Test
    void shouldMakeCellsWithNoAliveNeighboursDead() {

        List<Cell> initialState = new ArrayList<>();
        initialState.add(new Cell(0, 0));

        GameOfLife gameOfLife = new GameOfLife(initialState);

        assertTrue(gameOfLife.getNextState().isEmpty());

    }

    @Test
    void shouldMakeCellWithOneALiveNeighbourDead()
    {
        List<Cell> initialState = new ArrayList<>();
        initialState.add(new Cell(0, 0));
        initialState.add(new Cell(0,1));

        GameOfLife gameOfLife = new GameOfLife((initialState));

        assertTrue(gameOfLife.getNextState().isEmpty());
    }

    @Test
    void shouldNotChangeStateOfCellWithTwoLiveNeighbour()
    {
        List<Cell> initialState = new ArrayList<>();
        initialState.add(new Cell(1, 1));
        initialState.add(new Cell(2,1));
        initialState.add(new Cell(3,2));

        GameOfLife gameOfLife = new GameOfLife((initialState));
        List<Cell> expectedNextState = new ArrayList<>();
        expectedNextState.add(new Cell(2,1));
        expectedNextState.add(new Cell(2,2));

        assertTrue(expectedNextState.containsAll(gameOfLife.getNextState()));
    }

    @Test
    void shouldNotChangeStateOfCellWithThreeLiveNeighbours()
    {
        List<Cell> initialState = new ArrayList<>();
        initialState.add(new Cell(1, 1));
        initialState.add(new Cell(2,1));
        initialState.add(new Cell(3,2));
        initialState.add(new Cell(2,0));

        GameOfLife gameOfLife = new GameOfLife((initialState));
        List<Cell> expectedNextState = new ArrayList<>();
        expectedNextState.add(new Cell(1,0));
        expectedNextState.add(new Cell(1,1));
        expectedNextState.add(new Cell(2,0));
        expectedNextState.add(new Cell(2,1));
        expectedNextState.add(new Cell(2,2));
        expectedNextState.add(new Cell(3,1));

        assertTrue(expectedNextState.containsAll(gameOfLife.getNextState()));
    }


}
