import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCell {

    @Test
    public void shouldCreateALiveCell() {
        Cell cell = new Cell(1, 2, true);
        assertTrue(cell.isAlive());
    }
}