
package minesweeper.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains the gamelogic and provides tools for changing the state
 * of the Field and Tiles of the game.
 * 
 * @author Vivianna
 */
public class GameLogic {
    private final Field field;
    private final HashMap<Integer, HashMap<Integer, Tile>> tiles;
    private int mines;
    private int unopenedTiles;

    /**
     * Retrieves the HashMap that contains the Tiles of the field 
     * given as parameter.
     * 
     * @param field
     */
    public GameLogic(Field field) {
        this.field = field;
        this.tiles = field.getTiles();
        this.mines = field.getMines();
        this.unopenedTiles = field.getColumns() * field.getRows();
    }
    
    /**
     * Creates and returns a String representation of the minesNear attribute
     * of the Tile situated at (x, y).
     * Changes zeroes to empty Strings for Tiles that are not mined and to M
     * for those that are.
     * 
     * @param x the x coordinate of the Tile
     * @param y the y coordinate of the Tile
     * @return String representation of minesNear of a Tile
     */
    public String getMinesNearAsStringForTile(int x, int y) {
        int minesNear = this.tiles.get(x).get(y).getMinesNear();
        
        if (minesNear == 0 && this.tiles.get(x).get(y).isMined()) {
            return "M";
        } else if (minesNear == 0) {
            return "";
        }
        
        return String.valueOf(minesNear);
    }
    
    /**
     * Checks if the tile at the given coordinates should be opened.
     * Also sets opened for the tile and unopenedTiles for itself accordingly.
     *
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     * @return tile needs to be opened (true/false)
     */
    public boolean openTile(int x, int y) {
        boolean opened = tiles.get(x).get(y).open();
        if (opened) {
            this.unopenedTiles--;
        }
        return opened;
    }
    
    /**
     * Checks whether a tile should be flagged or unflagged and 
     * sets the flagged status of the tile accordingly.
     *
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @return tile is to be flagged/not
     */
    public boolean flagTile(int x, int y) {
        Tile tile = tiles.get(x).get(y);
        
        if (tile.isOpened()) {
            return false;
        } else if (tile.isFlagged()) {
            tile.toggleFlagged();
            this.mines++;
            return false;
        }
        
        tile.toggleFlagged();
        this.mines--;
        return true;
    }
    
    /**
     * Finds the neighbouring tiles of a tile at the given coordinates
     * and from these tiles adds the coordinates of the unopened ones to a Map.
     *
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @return map of coordinates for tiles to be opened
     */
    public Map<String, List<Integer>> openEmptyTiles(int x, int y) {
        Map<String, List<Integer>> opened = new HashMap<>();
        opened.put("x", new ArrayList<>());
        opened.put("y", new ArrayList<>());
        List<Tile> neighbours = field.getNeighbouringTiles(x, y);
        
        for (Tile tile:neighbours) {
            boolean wasOpened = tile.open();
            if (wasOpened) {
                opened.get("x").add(tile.getX());
                opened.get("y").add(tile.getY());
                this.unopenedTiles--;
            }
        }
        
        return opened;
    }

    public int getMines() {
        return mines;
    }
    
    private boolean someTileWronglyFlagged() { 
        for (int x = 0; x < this.field.getColumns(); x++) {
            long wrong = this.tiles.get(x).entrySet().stream()
                                                     .map(key -> key.getValue())
                                                     .filter(value -> value.wronglyFlagged() == true)
                                                     .count();
            
            if (wrong > 0) {
                return true;
            }
        }
                             
        return false;
    }
    
    public boolean gameIsWon() {
        if (!someTileWronglyFlagged() && this.mines == 0) {
            return true;
        } else if (this.unopenedTiles == this.field.getMines()) {
            return true;
        }
        
        return false;
    }

    public Field getField() {
        return field;
    }    
    
    public int getUnopenedTiles() {
        return unopenedTiles;
    }
        
}
