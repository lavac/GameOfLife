import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGrid {

    @Test
    public void shouldAddCellToTheGrid() {
        Grid grid = new Grid(4, 4);
        Cell cell = new Cell(1, 2, true);
        grid.add(cell);
        assertEquals(cell,grid.getCell(cell.getxCoordinate(), cell.getyCoordinate()));
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
        grid.tick();
        assertEquals(cell1, grid.getCell(1, 1));
        assertEquals(cell2, grid.getCell(1,2));
        assertEquals(cell3, grid.getCell(2,1));
    }
}
