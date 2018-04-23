
package minesweeper.ui;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import minesweeper.domain.Field;
import minesweeper.domain.GameLogic;
import minesweeper.domain.Tile;


public class MinesweeperUI extends Application{
    //tilesize, height, width here later? Others?
    
    //Organise parts to own methods later?
    @Override
    public void start(Stage primaryStage) {
        Field field = new Field(16, 16, 40);
        HashMap<Integer, HashMap<Integer, Tile>> tiles = field.getTiles();
        GameLogic gamelogic = new GameLogic(field);
        
        BorderPane menulayout = new BorderPane();
        Pane gamelayout = new Pane();
        
        //menulayout
        Label menutitle = new Label("Minesweeper");
        Button newgamebutton = new Button("New Game");
        
        menulayout.setTop(menutitle);
        menulayout.setCenter(newgamebutton);
        menulayout.setPrefSize(300, 200);
        
        //gamelayout
        
        gamelayout.setPrefSize(640, 640);
        
        //tilelayouts (tilesize currently 40)
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                StackPane tilelayout = new StackPane();
                tilelayout.setTranslateX(x * 40);
                tilelayout.setTranslateY(y * 40);
                Rectangle r = new Rectangle(38, 38); //change size here
                r.setStroke(Color.LAVENDERBLUSH);
                Text text = new Text(String.valueOf(tiles.get(x).get(y).getMinesNear()));
                if (text.equals("0")) {
                    text = new Text("M");
                }
                text.setVisible(false);
                tilelayout.getChildren().add(r);
                tilelayout.getChildren().add(text);
                
                gamelayout.getChildren().add(tilelayout);
            }
        }
        
        //scenes
        Scene menuscene = new Scene(menulayout);
        Scene gamescene = new Scene(gamelayout);
        
        //actions
        newgamebutton.setOnAction((event) -> {
            primaryStage.setScene(gamescene);
        });
        
        primaryStage.setScene(menuscene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        
        launch(MinesweeperUI.class);
    }
}
