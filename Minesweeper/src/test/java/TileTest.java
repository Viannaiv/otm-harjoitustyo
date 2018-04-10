
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import minesweeper.domain.Tile;


public class TileTest {
    
    Tile tile;
    
    @Before
    public void setUp() {
        tile = new Tile(10, 30, true);
    }

    @Test
    public void constructorSetsXCoordinateCorrectly() {
        assertEquals(10, tile.getX());
    }
    
    @Test
    public void constructorSetsYCoordinateCorrectly() {
        assertEquals(30, tile.getY());
    }
    
    @Test
    public void constructorSetsMinedCorrectly() {
        assertEquals(true, tile.isMined());
    }
    
    @Test
    public void constructorSetsFlaggedCorrectly() {
        assertEquals(false, tile.isFlagged());
    }
    
    @Test
    public void constructorSetsOpenedCorrectly() {
        assertEquals(false, tile.isOpened());
    }
    
    @Test
    public void constructorSetsMinesNearCorrectly() {
        assertEquals(0, tile.getMinesNear());
    }
    
    @Test
    public void setXSetsXCorrectly() {
        tile.setX(1);
        assertEquals(1, tile.getX());
    }
    
    public void setYSetsYCorrectly() {
        tile.setY(50);
        assertEquals(50, tile.getY());
    }
    
    public void toggleFlaggedAddsFlagWhenTileNotFlagged() {
        tile.toggleFlagged();
        assertEquals(true, tile.isFlagged());
    }
    
    public void toggleFlaggedRemovesFlagWhenTileFlagged() {
        tile.toggleFlagged();
        tile.toggleFlagged();
        assertEquals(false, tile.isFlagged());
    }
}
