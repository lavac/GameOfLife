import java.util.ArrayList;

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

    public Grid nextGeneration() {
        for (int row = 0; row < upperXCoordinate; row++) {
            for (int column = 0; column < upperYCoordinate; column++) {
                int countOfLiveNeighbours = getCountOfLiveNeighbours(row, column);
                if(isValidCell(row, column)) {
                    if (countOfLiveNeighbours != 2 && countOfLiveNeighbours != 3) {
                        getCell(row, column).setFutureCellState(false);
                    }
                    if (!(getCell(row, column).isAlive()) && countOfLiveNeighbours == 3) {
                        getCell(row, column).setFutureCellState(true);
                    }
                }
            }
        }
        return generateNewGenerationGrid();
    }

    private Grid generateNewGenerationGrid() {
        Grid nextGenerationGrid = new Grid(upperXCoordinate, upperYCoordinate);
        for (int row = 0; row <= upperXCoordinate; row++) {
            for (int column = 0; column <= upperYCoordinate; column++) {
                if(isValidCell(row, column)) {
                    Cell currentCell = getCell(row, column);
                    currentCell.applyStateTransition();
                    nextGenerationGrid.add(currentCell);
                }
            }
        }
        return nextGenerationGrid;
    }

    private int getCountOfLiveNeighbours(int row, int column) {
        int aliveNeighbours = 0;
        for (int currentRow = row - 1; currentRow <= row + 1; currentRow++) {
            for (int currentColumn = column - 1; currentColumn <= column + 1; currentColumn++) {
                if (isValidCell(currentRow, currentColumn)) {
                    Cell currentCell;
                    if (isCellAvailable(currentRow, currentColumn)) {
                        currentCell = getCell(currentRow, currentColumn);
                    } else {
                        currentCell = new Cell(currentRow, currentColumn,
                                               false);
                        add(currentCell);
                    }
                    if (currentCell.isAlive())
                        aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

    private boolean isCellAvailable(int xCoordinate, int yCoordinate) {
        if (getCell(xCoordinate, yCoordinate) != null)
            return true;
        return false;
    }

    private boolean isValidCell(int xCoordinate, int yCoordinate) {
        if (xCoordinate <= upperXCoordinate && yCoordinate <= upperYCoordinate
                && xCoordinate >= 0 && yCoordinate >= 0)
            return true;
        return false;
    }

    public ArrayList<Cell> getListOfLiveCells() {
        ArrayList<Cell> listOfLiveCells = new ArrayList<>();

        for (int row = 0; row <= upperXCoordinate; row++) {
            for (int column = 0; column <= upperYCoordinate; column++) {
                if (isValidCell(row, column) &&  getCell(row, column).isAlive()) {
                    listOfLiveCells.add(getCell(row, column));
                }
            }
        }
    return listOfLiveCells;
    }
}
