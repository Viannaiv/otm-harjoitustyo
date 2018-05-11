
package domain;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import minesweeper.domain.Field;
import minesweeper.domain.GameLogic;
import minesweeper.domain.Tile;


public class GameLogicTest {
    GameLogic game;
    HashMap<Integer, HashMap<Integer, Tile>> tiles;
    
    @Before
    public void setUp() {
        Field field = new Field(5, 5, 4);
        game = new GameLogic(field);
        tiles = field.getTiles();
    }

    @Test
    public void constructorSetsUnopenedTilesCorrectly() {
        assertEquals(25, game.getUnopenedTiles());
    }
    
    @Test
    public void openTileReturnsTrueWhenOpensTile() {
        assertEquals(true, game.openTile(0, 0));
    }
    
    @Test
    public void openTileReturnsFalseWhenDoesntOpenTile() {
        tiles.get(0).get(0).open();
        assertEquals(false, game.openTile(0, 0));
    }
    
    @Test
    public void openTileRemovesFromUnopenedTilesWhenOpensTile() {
        game.openTile(0, 0);
        assertEquals(24, game.getUnopenedTiles());
    }
    
    @Test
    public void openTileDoesntRemoveFromUnopenedTilesWhenDoesntOpensTile() {
        game.openTile(0, 0);
        game.openTile(0, 0);
        assertEquals(24, game.getUnopenedTiles());
    }
    
    @Test
    public void flagTileReturnsFalseWhenTileIsOpen() {
        game.openTile(0, 0);
        assertEquals(false, game.flagTile(0, 0));
    }
    
    @Test
    public void flagTileFlagsTileWhenTileNotFlaggedAndNotOpened() {
        game.flagTile(0, 0);
        assertEquals(true, tiles.get(0).get(0).isFlagged());
    }
    
    @Test
    public void flagTileReturnsFalseWhenTileIsFlagged() {
        game.flagTile(0, 0);
        assertEquals(false, game.flagTile(0, 0));
    }
    
    @Test
    public void flagTileUnflagsTileWhenTileFlagged() {
        game.flagTile(0, 0);
        game.flagTile(0, 0);
        assertEquals(false, tiles.get(0).get(0).isFlagged());
    }
        
    @Test
    public void flagTileRemovesFromMinesWhenFlagsTile() {
        game.flagTile(0, 0);
        game.flagTile(1, 0);
        assertEquals(2, game.getMines());
    }
    
    @Test
    public void flagTileAddsToMinesWhenUnflagsTile() {
        game.flagTile(0, 0);
        game.flagTile(1, 0);
        game.flagTile(0, 0);
        assertEquals(3, game.getMines());
    }

}
