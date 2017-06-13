public class Cell {

    private int xCoordinate;
    private int yCoordinate;
    private boolean isAlive;
    private boolean futureCellState;

    public Cell(int xCoordinate, int yCoordinate, boolean isAlive) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isAlive = isAlive;
    }

    boolean isAlive() {
        return isAlive;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void applyStateTransition() {
        setAlive(futureCellState);
    }

    public void setFutureCellState(boolean futureCellState) {
        this.futureCellState = futureCellState;
    }
}
