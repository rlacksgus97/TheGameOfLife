package com.holub.life;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UniverseTest {

    private Universe universe = new Universe(0);

    @Test
    public void backNowTest() {
        mockClick(4,4,2,2);
        mockClick(4,4,2,3);
        mockClick(4,4,2,4);
        mockClick(4,4,3,2);
        mockClick(4,4,3,3);
        mockClick(4,4,3,4);
        mockClick(4,4,4,2);
        mockClick(4,4,4,3);
        mockClick(4,4,4,4);

        universe.refreshNowTest();
        ArrayList<Storable> beforeBack = universe.getState();

        universe.refreshNowTest();
        universe.backNowTest();
        Cell outermostCell = universe.getOutermostCell();

        Neighborhood.NeighborhoodState original = (Neighborhood.NeighborhoodState) beforeBack.get(beforeBack.size() - 2);
        Neighborhood.NeighborhoodState expected = (Neighborhood.NeighborhoodState) outermostCell.createMemento();

        String originalState = original.toString();
        String expectedState = expected.toString();

        Assertions.assertEquals(originalState, expectedState);
    }

    public void mockClick(int x1, int y1, int x2, int y2) {
        Cell outermostCell = universe.getOutermostCell();
        Cell[][] neighborhoodGrid = outermostCell.getGrid();
        Cell[][] innerGrid = neighborhoodGrid[x1][y1].getGrid();

        Resident targetCell = (Resident) innerGrid[x2][y2];
        targetCell.setAmAlive(true);

        universe.getState().clear();

        Storable memento = outermostCell.createMemento();
        outermostCell.transfer(memento, new Point(0, 0), Cell.LOAD);
        universe.getState().add(memento);
    }
}