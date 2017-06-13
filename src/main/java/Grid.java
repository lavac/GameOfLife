public class Grid {
    private int upperXCoordinate;
    private int upperYCoordinate;
    private Cell[][] grid;

    public Grid(int upperXCoordinate, int upperYCoordinate) {
        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
        grid = new Cell[upperXCoordinate + 1][upperYCoordinate + 1];
    }

    public void add(Cell cell) {
        grid[cell.getxCoordinate()][cell.getyCoordinate()] = cell;
    }

    public Cell getCell(int xCoordinate, int yCoordinate) {
        return grid[xCoordinate][yCoordinate];
    }

    public void nextGeneration() {
        for (int row = 0; row < upperXCoordinate; row++) {
            for (int column = 0; column < upperYCoordinate; column++) {

                int countOfLiveNeighbours = getCountOfLiveNeighbours(row, column);
                if (countOfLiveNeighbours != 2 && countOfLiveNeighbours != 3
                        && isCellAvailable(row, column)) {
                    getCell(row, column).setAlive(false);
                }
                if (isCellAvailable(row, column) && !(getCell(row, column)
                        .isAlive()) && countOfLiveNeighbours
                        == 3) {
                    getCell(row, column).setAlive(true);
                }
            }
        }
    }

    private int getCountOfLiveNeighbours(int row, int column) {
        int aliveNeighbours = 0;
        for (int x = row - 1; x <= row + 1; x++) {
            for (int y = column - 1; y <= column + 1; y++) {

                if (isCellAvailable(x, y)) {
                    Cell currentCell = getCell(x, y);

                    if (currentCell.isAlive())
                        aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

    private boolean isCellAvailable(int xCoordinate, int yCoordinate) {
        if (xCoordinate <= upperXCoordinate && yCoordinate <= upperYCoordinate
                && xCoordinate >= 0 && yCoordinate >= 0)
            if (getCell(xCoordinate, yCoordinate) != null)
                return true;
        return false;
    }
}
