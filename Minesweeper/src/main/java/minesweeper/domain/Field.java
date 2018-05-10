
package minesweeper.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * This class creates and stores the Tiles of a "Minefield".
 * Also provides information about the tiles in it.
 * 
 * @author Vivianna
 */
public class Field {
    private final int rows;
    private final int columns;
    private final int mines;
    private HashMap<Integer, HashMap<Integer, Tile>> tiles;
    private Random random;

    /**
     * This is constructor that creates a Field of given size.
     * Creates all the Tiles required for a field of given 
     * height and length, then places the given amount of mines 
     * into tiles at random coordinates on the field and then 
     * counts and adds to each tile the amount of mines near them.
     * 
     * @param columns the amount of columns in field
     * @param rows the amountof rows in a field
     * @param mines the total amount of mines in the field
     */
    public Field(int columns, int rows, int mines) { //mines could be in about 16% of the field (intermediate)
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
    
    /**
     * Finds the Tiles that are adjacent to the Tile in the given coordinates.
     * 
     * @param x
     * @param y
     * @return List of neighbouring Tiles
     */
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
    
}
