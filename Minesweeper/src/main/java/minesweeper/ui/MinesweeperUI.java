
package minesweeper.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import minesweeper.domain.Field;
import minesweeper.domain.GameLogic;

/**
 * The main class that launches the game and contains the user interface.
 * 
 * @author Vivianna
 */
public class MinesweeperUI extends Application{
    //tilesize, height, width here later? Others?
    
    //Organise parts to own methods later
    //Add timer + show time
    //Add mines count z/t
    @Override
    public void start(Stage primaryStage) {
        Field field = new Field(16, 16, 40);
        GameLogic gamelogic = new GameLogic(field);
        HashMap<Integer, HashMap<Integer, TileStackPane>> tilePanes = new HashMap<>();
        
        BorderPane menulayout = new BorderPane();
        Pane gamelayout = new Pane();
        BorderPane loselayout = new BorderPane();
        
        //menulayout
        Button newgamebutton = new Button("New Game");
        menulayout.setCenter(newgamebutton);
        menulayout.setPrefSize(480, 480);
        menulayout.setStyle("-fx-background-color: #b3ffff");
        
        //gamelayout
        gamelayout.setPrefSize(480, 480);
        
        //loselayout
        Text gameover = new Text("Game over. You set of a mine.");
        loselayout.setCenter(gameover);
        loselayout.setPrefSize(480, 480);
        loselayout.setStyle("-fx-background-color: #b3ffff");
        
        //winlayout
        
        
        //tilelayouts (tilesize 30)
        for (int x = 0; x < 16; x++) {
            tilePanes.put(x, new HashMap<>());
            for (int y = 0; y < 16; y++) {
                TileStackPane tilelayout = new TileStackPane(x, y, gamelogic.getMinesNearAsStringForTile(x, y));
                
                tilelayout.setOnMouseClicked((event) -> {                   
                    if (event.getButton().equals(MouseButton.SECONDARY)) {
                        boolean flagged = gamelogic.flagTile(tilelayout.getX(), tilelayout.getY());
                        tilelayout.flag(flagged);
                    } else {
                        boolean opened = gamelogic.openTile(tilelayout.getX(), tilelayout.getY());                      
                        if (opened) {
                            tilelayout.open();
                            if (tilelayout.getMinesNeartext().isEmpty()) {
                                Map<String, List<Integer>> toOpen = gamelogic.openEmptyTiles(tilelayout.getX(), tilelayout.getY());
                                while (!toOpen.get("x").isEmpty()) {
                                    TileStackPane openable = tilePanes.get(toOpen.get("x").get(0)).get(toOpen.get("y").get(0));
                                    openable.open();
                                    if (openable.getMinesNeartext().isEmpty()) {
                                        Map<String, List<Integer>> toOpenNew = gamelogic.openEmptyTiles(openable.getX(), openable.getY());
                                        List listX = toOpenNew.get("x");
                                        List listY = toOpenNew.get("y");
                                        
                                        while (!listX.isEmpty()) {
                                            toOpen.get("x").add(toOpenNew.get("x").get(0));
                                            toOpen.get("y").add(toOpenNew.get("y").get(0));
                                            toOpenNew.get("x").remove(0);
                                            toOpenNew.get("y").remove(0);
                                        }
                                    }
                                    
                                    toOpen.get("x").remove(0);
                                    toOpen.get("y").remove(0);
                                }
                            } else if (tilelayout.getMinesNeartext().equals("M")) {
                                primaryStage.setScene(new Scene(loselayout));
                            }
                        }
                        //TODO: stop game on victory
                        //TODO: start with opened empty tiles or ´the first clicked tile not being a mined one
                    }
                });
                
                tilePanes.get(x).put(y, tilelayout);
                gamelayout.getChildren().add(tilelayout);
            }
        }
        
        //TODO: Score and database
        
        //scenes
        Scene menuscene = new Scene(menulayout);
        Scene gamescene = new Scene(gamelayout);
        
        //actions
        newgamebutton.setOnAction((event) -> {
            primaryStage.setScene(gamescene);
        });
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(menuscene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        
        launch(MinesweeperUI.class);
    }
}
