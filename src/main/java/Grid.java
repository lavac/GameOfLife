public class Grid {
    private int upperXCoordinate;
    private int upperYCoordinate;
    private Cell[][] grid;

    public Grid(int upperXCoordinate, int upperYCoordinate) {
        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
        grid = new Cell[upperXCoordinate][upperYCoordinate];
    }

    public void add(Cell cell) {
        grid[cell.getxCoordinate()][cell.getyCoordinate()] = cell;
    }

    public Cell getCell(int xCoordinate, int yCoordinate) {
        return grid[xCoordinate][yCoordinate];
    }

    public void tick() {


    }
}
