
package minesweeper.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Field { //should I check that values are positive?
    private int rows;
    private int columns;
    private int mines;
    private HashMap<Integer, HashMap<Integer, Tile>> tiles;
    private Random random;

    public Field(int columns, int rows, int mines) { //mines could be in about 16% of the field
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
        int x = 0;
        
        while (x < this.columns) {
            this.tiles.putIfAbsent(x, new HashMap<>());
            int y = 0;
            
            while (y < this.rows) {
                Tile tile = new Tile(x, y, false);
                this.tiles.get(x).put(y, tile);
                
                y++;
            }
            x++;
        }

    }
    
    private void addMinesToField() {
        int minesNeeded = this.mines;
        
        while (minesNeeded > 0) {
            int x = random.nextInt(this.columns);
            int y = random.nextInt(this.rows);
            
            if (!this.tiles.get(x).get(y).isMined()) {
                this.tiles.get(x).get(y).setMined(true);
                minesNeeded--;
            }
        }
    }
    
    public List<Tile> getNeighbouringTiles(int x, int y) {
        List<Tile> neighbours = new ArrayList<>();
        
        if (y + 1 < this.rows) {
            neighbours.add(this.tiles.get(x).get(y + 1));
            
            if (x - 1 >= 0) {
                neighbours.add(this.tiles.get(x - 1).get(y + 1));
            }
            
            if (x + 1 < this.columns) {
                neighbours.add(this.tiles.get(x + 1).get(y + 1));
            }
        }
        
        if (x + 1 < this.columns) {
            neighbours.add(this.tiles.get(x + 1).get(y));
        }
        
        if (x - 1 >= 0) {
            neighbours.add(this.tiles.get(x - 1).get(y));
        }
        
        if (y - 1 >= 0) {
            neighbours.add(this.tiles.get(x).get(y - 1));
            
            if (x - 1 >= 0) {
                neighbours.add(this.tiles.get(x - 1).get(y - 1));
            }
            
            if (x + 1 < this.columns) {
                neighbours.add(this.tiles.get(x + 1).get(y - 1));
            }
        }
        
        return neighbours;
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
        
        for (int x = 0; x < this.columns; x++) {
            
            for (int y = 0; y < this.rows; y++) {
                if (!this.tiles.get(x).get(y).isMined()) {
                    List<Tile> neighbours = getNeighbouringTiles(x, y);
                
                    long minesNear = neighbours.stream()
                                               .filter(tile -> tile.isMined() == true)
                                               .count();
                    
                    this.tiles.get(x).get(y).setMinesNear((int) minesNear);
                }
            }
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
    
    //Should there be a get with xCoords method?
    
}
