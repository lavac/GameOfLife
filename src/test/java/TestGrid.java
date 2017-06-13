import org.junit.Test;

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
        grid.nextGeneration();
        assertFalse(grid.getCell(0, 0).isAlive());
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
        grid.nextGeneration();

        assertFalse(grid.getCell(1, 1).isAlive());
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


//    @Test
//    public void shouldReturnTheNextGenerationCells() {
//        Grid grid = new Grid(4, 4);
//        Cell cell1 = new Cell(1, 1, true);
//        Cell cell2 = new Cell(1, 2, true);
//        Cell cell3 = new Cell(2, 1, true);
//        grid.add(cell1);
//        grid.add(cell2);
//        grid.add(cell3);
//        grid.nextGeneration();
//        assertEquals(cell1, grid.getCell(1, 1));
//        assertEquals(cell2, grid.getCell(1,2));
//        assertEquals(cell3, grid.getCell(2,1));
//    }
}
