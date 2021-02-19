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

            List<Cell> neighbours = liveCell.getNeighbours();
            explored.add(liveCell);

            stateOFCurrentCell(liveCells, liveCell, neighbours);

        }
        return liveCells;
    }


    private void stateOFCurrentCell(List<Cell> liveCells, Cell liveCell, List<Cell> neighbours) {
        int countLiveNeighbours = liveNeighboursCount(neighbours);

        if (countLiveNeighbours < 2)
            liveCells.remove(liveCell);
    }


    private int liveNeighboursCount(List<Cell> neighbours) {
        return neighbours.stream()
                .filter(initialState::contains)
                .collect(Collectors.toList()).size();
    }

}
