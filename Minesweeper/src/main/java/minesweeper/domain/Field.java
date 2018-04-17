
package minesweeper.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//This might not be the final solution if i figure out something that works better

public class Field { //should i check that values are positive
    private int rows;
    private int columns;
    private int mines;
    private HashMap<Integer, HashMap<Integer, Tile>> tiles;
    private Random random;

    public Field(int rows, int columns, int mines) { //mines could be in about 16% of the field
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.tiles = new HashMap<>();
        this.random = new Random();
        
        createTiles();
        addMinesToField();
        setMinesNearForTiles();
    }
    
    private void createTiles() {
        for (int y = 0; y < this.rows; y++) {
            
            for (int x = 0; x < this.columns; x++) {
                tiles.put(x, new HashMap<>());
                tiles.get(x).put(y, new Tile(x, y, false));
            }
        }
    }
    
    private void addMinesToField() {
        int minesNeeded = this.mines;
        
        while (minesNeeded > 0) {
            int x = random.nextInt(this.columns);
            int y = random.nextInt(this.rows);
            
            Tile tile = tiles.get(x).get(y);
            
            if (!tile.isMined()) {
                tile.setMined(true);
                minesNeeded--;
            }
        }
    }
    
    //Maybe this should be counted separately only when required?
    // especially if I set the first tile clicked
    // to be clear even if originaly mined, thus changing minesNear for some tiles? 
    //Then it would not be needed in tiles?
    // anyway this is a problem for later!
    private void setMinesNearForTiles() {
        /*
        Currently only makes changes for tiles that are empty.
        Since mined tiles do not need this information, considering they do not
        show a number when opened.
        */
        setMinesNearInCenterTiles();
        setMinesNearInSideTiles();
        setMinesNearInCornerTiles();
    }
    
    // make this more reasonable later. Just like the others too. 
    // This should be done only when needed.
    //I AM AWARE this is not very efficient way to handle the problem
    private void setMinesNearInCenterTiles() {
        for (int y = 1; y < this.rows - 1; y++) {
            
            for (int x = 1; x < this.columns - 1; x++){
                int minesNear = 0;
                Tile tile = tiles.get(x).get(y);
                if (!tile.isMined()) {
                    for(int y2 = y + 1; y2 >= y - 1; y2--) {
                        for(int x2 = x - 1; x2 <= x + 1; x2++) {
                            if (tiles.get(x2).get(y2).isMined()) {
                                minesNear++;
                            }
                        }
                    }
                    
                    tile.setMinesNear(minesNear);
                }
            }
        }
    }
    
    //Maybe make a method getNeigbouringTiles() if needed
    
    private void setMinesNearInSideTiles() {
        //from (0.1) to (0.(this.rows-2))
        for (int y = 1; y < this.rows - 1; y++){
            int minesNear = 0;
            Tile tile = tiles.get(0).get(y);
            if (!tile.isMined()) {
                for(int y2 = y - 1; y2 <= y + 1; y2++) {
                    for(int x = 0; x <= x + 1; x++) {
                        if (tiles.get(x).get(y2).isMined()) {
                            minesNear++;
                        }
                    }
                }
                tile.setMinesNear(minesNear);
            }
        }
        
        //from ((this.columns - 1).1) to ((this.columns - 1).(this.rows -2))
        for (int y = 1; y < this.rows - 1; y++){
            int minesNear = 0;
            Tile tile = tiles.get(this.columns - 1).get(y);
            if (!tile.isMined()) {
                for(int y2 = y - 1; y2 <= y + 1; y2++) {
                    for(int x = this.columns - 1; x >= x - 1; x--) {
                        if (tiles.get(x).get(y2).isMined()) {
                            minesNear++;
                        }
                    }
                }
                tile.setMinesNear(minesNear);
            }
        }
        
        //from (1.0) to ((this.columns - 2).0) to 
        for (int x = 1; x < this.columns - 1; x++){
            int minesNear = 0;
            Tile tile = tiles.get(x).get(0);
            if (!tile.isMined()) {
                for(int x2 = x - 1; x2 <= x + 1; x2++) {
                    for(int y = 0; y <= y + 1; y++) {
                        if (tiles.get(x2).get(y).isMined()) {
                            minesNear++;
                        }
                    }
                }
                tile.setMinesNear(minesNear);
            }
        }
        
        //from (1.((rows -2)) to ((columns -2).(rows -2))
        for (int x = 1; x < this.columns - 1; x++){
            int minesNear = 0;
            Tile tile = tiles.get(x).get(this.rows - 1);
            if (!tile.isMined()) {
                for(int x2 = x - 1; x2 <= x + 1; x2++) {
                    for(int y = this.rows - 1; y >= y - 1; y--) {
                        if (tiles.get(x2).get(y).isMined()) {
                            minesNear++;
                        }
                    }
                }
                tile.setMinesNear(minesNear);
            }
        }
    }
    
    private void setMinesNearInCornerTiles() {
        //(0.0)
        int minesNear = 0;
        Tile tile = tiles.get(0).get(0);
        if(!tile.isMined()) {
            for(int y = 0; y <= 1; y++) {
                for(int x = 0; x <= 1; x++) {
                    if(tiles.get(x).get(y).isMined()) {
                        minesNear++;
                    }
                }
            }
            tile.setMinesNear(minesNear);
        }
        
        //(0.(rows - 1))
        minesNear = 0;
        tile = tiles.get(0).get(this.rows - 1);
        if(!tile.isMined()) {
            for(int y = this.rows - 1; y >= this.rows - 2; y--) {
                for(int x = 0; x <= 1; x++) {
                    if(tiles.get(x).get(y).isMined()) {
                        minesNear++;
                    }
                }
            }
            tile.setMinesNear(minesNear);
        }
        
        //((columns - 1).0)
        minesNear = 0;
        tile = tiles.get(this.columns - 1).get(0);
        if(!tile.isMined()) {
            for(int y = 0; y <= 1; y++) {
                for(int x = this.columns - 1; x >= this.columns - 2; x--) {
                    if(tiles.get(x).get(y).isMined()) {
                        minesNear++;
                    }
                }
            }
            tile.setMinesNear(minesNear);
        }
        
        //((columns -1).(rows - 1))
        minesNear = 0;
        tile = tiles.get(this.columns - 1).get(this.rows - 1);
        if(!tile.isMined()) {
            for(int y = this.rows - 1; y >= this.rows - 2; y--) {
                for(int x = this.columns - 1; x >= this.columns - 2; x--) {
                    if(tiles.get(x).get(y).isMined()) {
                        minesNear++;
                    }
                }
            }
            tile.setMinesNear(minesNear);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }
    
    public HashMap<Integer, HashMap<Integer, Tile>> getTiles() {
        return tiles;
    }
    
    
    
}
