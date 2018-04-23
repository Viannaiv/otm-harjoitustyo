
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import minesweeper.domain.Field;
import minesweeper.domain.GameLogic;


public class GameLogicTest {
    GameLogic game;
    
    @Before
    public void setUp() {
        Field field = new Field(5, 5, 4);
        game = new GameLogic(field);
    }

    // @Test
    // public void hello() {}
}
