package com.tw.game.of.life.task;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

    final List<Cell> initialState;

    public GameOfLife(List<Cell> initialState) {
        this.initialState = initialState;
    }

    public List<Cell> getNextState() {
        List<Cell> liveCells = new ArrayList<>(initialState);
        HashSet<Cell> explored = new HashSet<>();

        for (Cell liveCell : initialState) {

            if(!explored.contains(liveCell)) {
                List<Cell> neighbours = liveCell.getNeighbours();
                explored.add(liveCell);

                stateOfCurrentCell(liveCells, liveCell, neighbours);
                stateOfNeighbours(liveCells, neighbours, explored);
            }
        }
        return liveCells;
    }

    private void stateOfCurrentCell(List<Cell> liveCells, Cell cell, List<Cell> neighbours) {
        int countLiveNeighbours = liveNeighboursCount(neighbours);

        if(!initialState.contains(cell) && countLiveNeighbours == 3)
            liveCells.add(cell);
        else if(countLiveNeighbours < 2)
            liveCells.remove(cell);


    }

    private void stateOfNeighbours(List<Cell> liveCells, List<Cell> neighbours, HashSet<Cell> explored) {

        for(Cell neighbouringCell : neighbours)
        {
            if(!explored.contains(neighbouringCell))
            {
                List<Cell> neighboursOfNeighbouringCell = neighbouringCell.getNeighbours();

                stateOfCurrentCell(liveCells, neighbouringCell, neighboursOfNeighbouringCell);

                explored.add(neighbouringCell);
            }
        }
    }

    private int liveNeighboursCount(List<Cell> neighbours) {
        return neighbours.stream()
                .filter(initialState::contains)
                .collect(Collectors.toList()).size();
    }


}
