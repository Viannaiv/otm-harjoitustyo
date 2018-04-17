package domain;


import java.util.HashMap;
import java.util.Map;
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
        HashMap tiles = field.getTiles();
        int tilecount = 0;
        for(int x = 0; x < 5; x++) {
            tilecount += tiles.keySet().size();
        }
                             
        assertEquals(25, tilecount);
    }
}
