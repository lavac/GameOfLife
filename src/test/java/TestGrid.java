import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestGrid {

    @Test
    public void shouldAddCellToTheGrid() {
        Grid grid = new Grid(4, 4);
        Cell cell = new Cell(1, 2, true);

        grid.add(cell);

        assertEquals(cell,grid.getCell(cell.getxCoordinate(), cell.getyCoordinate()));
    }

    @Test
    public void aLonelyCellShouldDieInNextGeneration() {
        Grid grid = new Grid(4, 4);
        Cell cell1 = new Cell(0, 0, true);

        grid.add(cell1);

        Grid nextGenerationGrid = grid.nextGeneration();
        assertFalse(nextGenerationGrid.getCell(0, 0).isAlive());
    }

    @Test
    public void anOverCrowdedCellShouldDieInTheNextGeneration() {
        Grid grid = new Grid(4, 4);
        Cell cell1 = new Cell(1, 1, true);
        Cell cell2 = new Cell(1, 2, true);
        Cell cell3 = new Cell(0, 1, true);
        Cell cell4 = new Cell(2, 1, true);
        Cell cell5 = new Cell(2, 2, true);

        grid.add(cell1);
        grid.add(cell2);
        grid.add(cell3);
        grid.add(cell4);
        grid.add(cell5);
        Grid nextGenerationGrid = grid.nextGeneration();

        assertFalse(nextGenerationGrid.getCell(1, 1).isAlive());
    }

    @Test
    public void deadCellResurrectsInNextGeneration() {
        Grid grid = new Grid(4, 4);
        Cell cell1 = new Cell(0, 0, false);
        Cell cell2 = new Cell(0, 1, true);
        Cell cell3 = new Cell(1, 0, true);
        Cell cell4 = new Cell(1, 1, true);

        grid.add(cell1);
        grid.add(cell2);
        grid.add(cell3);
        grid.add(cell4);
        grid.nextGeneration();

        assertTrue(cell1.isAlive());
    }

    @Test
    public void shouldReturnTheNextGenerationCells() {
        Grid grid = new Grid(4, 4);
        Cell cell1 = new Cell(1, 1, true);
        Cell cell2 = new Cell(1, 2, true);
        Cell cell3 = new Cell(2, 1, true);

        grid.add(cell1);
        grid.add(cell2);
        grid.add(cell3);

        Grid nextGenerationGrid = grid.nextGeneration();

        assertEquals(cell1, nextGenerationGrid.getCell(1, 1));
        assertEquals(cell2, nextGenerationGrid.getCell(1,2));
        assertEquals(cell3, nextGenerationGrid.getCell(2,1));
    }

    @Test
    public void shouldReturnTheCellsAliveInNextGeneration() {

        Grid grid = new Grid(4, 4);

        Cell cell1 = new Cell(1, 1, true);
        Cell cell2 = new Cell(1, 2, true);
        Cell cell3 = new Cell(1, 3, true);
        Cell cell4 = new Cell(2, 2, true);
        Cell cell5 = new Cell(2, 3, true);
        Cell cell6 = new Cell(2, 4, true);

        grid.add(cell1);
        grid.add(cell2);
        grid.add(cell3);
        grid.add(cell4);
        grid.add(cell5);
        grid.add(cell6);

        Grid nextGenerationGrid = grid.nextGeneration();


        ArrayList<Cell> listOfExpectedCells = new ArrayList<>();

        Cell expectedCell1 = new Cell(0, 2, true);
        Cell expectedCell2 = new Cell(1, 1, true);
        Cell expectedCell3 = new Cell(1, 4, true);
        Cell expectedCell4 = new Cell(2, 1, true);
        Cell expectedCell5 = new Cell(2, 4, true);
        Cell expectedCell6 = new Cell(3, 3, true);

        listOfExpectedCells.add(expectedCell1);
        listOfExpectedCells.add(expectedCell2);
        listOfExpectedCells.add(expectedCell3);
        listOfExpectedCells.add(expectedCell4);
        listOfExpectedCells.add(expectedCell5);
        listOfExpectedCells.add(expectedCell6);
        
        assertEquals(listOfExpectedCells, nextGenerationGrid.getListOfLiveCells());
    }
}
