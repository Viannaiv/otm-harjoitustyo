
package minesweeper.ui;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Vivianna
 */
public class TileStackPane extends StackPane {
    private int x;
    private int y;
    private Text minesNear;
    private Text flag;
    private Rectangle rectangle;

    public TileStackPane(int x, int y, String minesNear) {
        this.x = x;
        this.y = y;
        setTranslateX(x * 30);
        setTranslateY(y * 30);
        
        this.rectangle = new Rectangle(28, 28);
        this.rectangle.setFill(Color.DARKCYAN);
        
        this.minesNear = new Text(minesNear);
        this.minesNear.setVisible(false);
        this.flag = new Text("F");
        this.flag.setVisible(false);
        
        getChildren().addAll(this.rectangle, this.minesNear, this.flag);
    }
    
    public void open() {
        this.rectangle.setFill(Color.LIGHTBLUE);
        this.minesNear.setVisible(true);
        this.flag.setVisible(false);
    }
    
    public void flag(boolean flag) {
        this.flag.setVisible(flag);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getMinesNeartext() {
        return minesNear.getText();
    }
    
}