
package minesweeper.domain;


public class Tile {
    private int x;
    private int y;
    private boolean mined;
    private boolean flagged;
    private boolean opened;
    private int minesNear;

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
    
    public void toggleFlagged() {
        if (isFlagged() && !isOpened()) {
            this.flagged = false;
        } else if (!isOpened()) {
            this.flagged = true;
        }
    }
    
    public boolean wronglyFlagged() {
        return isFlagged() && !isMined();
    }
    
    public boolean open() {
        if (isOpened()) {
            return false;
        }
        
        this.opened = true;
        
        //delete if unnecessary in the final solution
        if (isFlagged()) {
            toggleFlagged();
        }
        
        return true;
    }
    
}
