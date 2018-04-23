
package minesweeper.domain;

import java.util.HashMap;


public class GameLogic {
    HashMap<Integer, HashMap<Integer, Tile>> tiles;

    public GameLogic(Field field) {
        this.tiles = field.getTiles();
    }
    
    public String getMinesNearAsStringForTile(int x, int y) {
        int mines = this.tiles.get(x).get(y).getMinesNear();
        
        if (mines == 0 && this.tiles.get(x).get(y).isMined()) {
            return "M";
        }else if (mines == 0) {
            return "";
        }
        
        return String.valueOf(mines);
    }
    
    public boolean openTile(int x, int y) {
        return true; // add when nreturn false
    }
    
    public boolean FlagTile(int x, int y) {
        return true; //add when returns false
    }
    
    public void openEmptyTiles(int x, int y) {
        //To be written later
    }
    
}
