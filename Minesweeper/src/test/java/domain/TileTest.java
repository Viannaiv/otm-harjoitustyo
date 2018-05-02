package domain;


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
    
    @Test
    public void setYSetsYCorrectly() {
        tile.setY(50);
        assertEquals(50, tile.getY());
    }
    
    @Test
    public void setMinedSetsMinedCorrectly() {
        tile.setMined(false);
        assertEquals(false, tile.isMined());
    }
    
    @Test
    public void setMinesNearSetsMinesNearCorrectly() {
        tile.setMinesNear(4);
        assertEquals(4, tile.getMinesNear());
    }
    
    @Test
    public void toggleFlaggedAddsFlagWhenTileNotFlagged() {
        tile.toggleFlagged();
        assertEquals(true, tile.isFlagged());
    }
    
    @Test
    public void toggleFlaggedRemovesFlagWhenTileFlagged() {
        tile.toggleFlagged();
        tile.toggleFlagged();
        assertEquals(false, tile.isFlagged());
    }
    
    @Test
    public void wronglyFlaggedReturnsTrueWhenFlaggedAndNotMined() {
        tile.toggleFlagged();
        tile.setMined(false);
        assertEquals(true, tile.wronglyFlagged());
    }
    
    @Test
    public void wronglyFlaggedReturnsFalseWhenFlaggedAndMined() {
        tile.toggleFlagged();
        assertEquals(false, tile.wronglyFlagged());
    }
    
    @Test
    public void wronglyFlaggedReturnsFlaseWhenNotFlaggedAndNotMined() {
        tile.setMined(false);
        assertEquals(false, tile.wronglyFlagged());
    }
    
    @Test
    public void wronglyFlaggedReturnsFalseWhenNotFlaggedAndMined() {
        assertEquals(false, tile.wronglyFlagged());
    }
    
    @Test
    public void openReturnsTrueWhenTileIsNotOpenAlready() {
        assertEquals(true, tile.open());
    }
    
    @Test
    public void openSetsOpenedCorrectlyWhenOpensTile() {
        tile.open();
        assertEquals(true, tile.isOpened());
    }
    
    @Test
    public void openReturnsFalseWhenAlreadyOpened() {
        tile.open();
        assertEquals(false, tile.open());
    }
    
    @Test
    public void openRemovesFlagWhenOpensTile() {
        tile.toggleFlagged();
        tile.open();
        assertEquals(false, tile.isFlagged());
    }
}    