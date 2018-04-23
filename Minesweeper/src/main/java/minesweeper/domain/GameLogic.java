
package minesweeper.domain;

import java.util.HashMap;


public class GameLogic {
    HashMap<Integer, HashMap<Integer, Tile>> tiles;

    public GameLogic(Field field) {
        this.tiles = field.getTiles();
    }
    
    public boolean openTile() {
        return true;
    }
    
}
