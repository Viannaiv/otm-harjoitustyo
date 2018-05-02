
package minesweeper.domain;

import java.util.HashMap;

/**
 * Contains the gamelogic and provides tools for changing the state
 * of the Field and Tiles of the game.
 * 
 * @author Vivianna
 */
public class GameLogic {
    HashMap<Integer, HashMap<Integer, Tile>> tiles;

    /**
     * Retrieves the HashMap that contains the Tiles of the field 
     * given as parameter.
     * 
     * @param field
     */
    public GameLogic(Field field) {
        this.tiles = field.getTiles();
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
        int mines = this.tiles.get(x).get(y).getMinesNear();
        
        if (mines == 0 && this.tiles.get(x).get(y).isMined()) {
            return "M";
        } else if (mines == 0) {
            return "";
        }
        
        return String.valueOf(mines);
    }
    
    public boolean openTile(int x, int y) {
        return true; // add when nreturn false
    }
    
    public boolean flagTile(int x, int y) {
        return true; //add when returns false
    }
    
    public void openEmptyTiles(int x, int y) {
        //To be written later
    }
    
}
