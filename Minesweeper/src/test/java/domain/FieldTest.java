package domain;


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
    
//    @Test
//    public void constructorCreatesTheRightNumberOfTiles() {
//        assertEquals(25, field.getTiles().keySet().size());
//    }
}
