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
}
