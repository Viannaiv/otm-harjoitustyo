
package minesweeper.domain;

/**
 * This class represents a tile in a Minefield situated
 * at (x, y).
 * 
 * @author Vivianna
 */
public class Tile {
    private int x;
    private int y;
    private boolean mined;
    private boolean flagged;
    private boolean opened;
    private int minesNear;

    /**
     * Creates a new Tile in given coordinates (x, y), 
     * with or without a mine.
     * The Tile is created as non-flagged, non-opened and
     * with a minesNear value of 0.
     *
     * @param x the x coordinate of the Tile
     * @param y the y coordinate of the Tile
     * @param mined there is/isn't a mine in this Tile
     */
    public Tile(int x, int y, boolean mined) {
        this.x = x;
        this.y = y;
        this.mined = mined;
        this.flagged = false;
        this.opened = false;
        this.minesNear = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMined() {
        return mined;
    }

    public void setMined(boolean mined) {
        this.mined = mined;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean isOpened() {
        return opened;
    }

    public int getMinesNear() {
        return minesNear;
    }

    public void setMinesNear(int minesNear) {
        this.minesNear = minesNear;
    }
    
    /**
     * Checks if the Tile should be flagged or unflagged, 
     * and sets the value of flagged accordingly.
     */
    public void toggleFlagged() {
        if (isFlagged() && !isOpened()) {
            this.flagged = false;
        } else if (!isOpened()) {
            this.flagged = true;
        } else if (isOpened() && isFlagged()) {
            this.flagged = false;
        }
    }
    
    /**
     * Checks whether the Tile has been flagged without it containing a mine.
     *
     * @return Tile is/isn't flagged unnecessarily
     */
    public boolean wronglyFlagged() {
        return isFlagged() && !isMined();
    }
    
    /**
     * Sets opened as true for an unopened Tile 
     * and removes flags from it if there is any.
     * 
     * @return tile was opened (true/false)
     */
    public boolean open() {
        if (isOpened()) {
            return false;
        }
        
        this.opened = true;
        
        if (isFlagged()) {
            toggleFlagged();
        }
        
        return true;
    }
    
}
