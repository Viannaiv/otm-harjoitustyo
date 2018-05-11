package domain;


import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import minesweeper.domain.Field;
import minesweeper.domain.Tile;


public class FieldTest {
    Field field;
    
    @Before
    public void setUp() {
        field = new Field(5, 5, 4);
    }
    
    @Test
    public void constructorCreatesTheRightNumberOfTiles() {
        HashMap<Integer, HashMap<Integer, Tile>> tiles = field.getTiles();
        int tilecount = 0;
        int x = 0;
        
        while (x < 5) {
            tilecount += tiles.get(x).size();
            x++;
        }
        
        assertEquals(25, tilecount);
    }
}
