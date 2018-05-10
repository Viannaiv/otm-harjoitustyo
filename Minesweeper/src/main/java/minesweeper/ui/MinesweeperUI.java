
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
    
    //add easy and hard
    //Add timer + show time
    //Add mines count z/t
    private Scene menuscene;
    private Scene gamescene;
    private Scene losescene;
    private Scene winscene;
    
    private GameLogic gamelogic;
    private HashMap<Integer, HashMap<Integer, TileStackPane>> tilePanes;
    
    public Scene createMenuscene(int width, int height, Stage stage) {
        BorderPane menulayout = new BorderPane();
        
        Button newgamebutton = new Button("New Game");
        menulayout.setCenter(newgamebutton);
        menulayout.setPrefSize(width, height);
        menulayout.setStyle("-fx-background-color: #b3ffff");
        
        newgamebutton.setOnAction((event) -> {
            stage.setScene(this.gamescene);
        });
        
        return new Scene(menulayout);
    }
    
    public Scene createLosescene(int width, int height, Stage stage) {
        BorderPane loselayout = new BorderPane();
        
        Text gameover = new Text("Game over. You set of a mine.");
        loselayout.setCenter(gameover);
        loselayout.setPrefSize(width, height);
        loselayout.setStyle("-fx-background-color: #b3ffff");
        
        return new Scene(loselayout);
    }
    
    public Scene createWinscene(int width, int height, Stage stage) {
        BorderPane winlayout = new BorderPane();
        
        Text gamewon = new Text("You won.");
        winlayout.setCenter(gamewon);
        winlayout.setPrefSize(width, height);
        winlayout.setStyle("-fx-background-color: #b3ffff");
        
        return new Scene(winlayout);
    }
    
    public Scene createGamescene(int width, int height, Stage stage) {
        Pane gamelayout = new Pane();
        gamelayout.setPrefSize(width, height);
        
        //tilelayouts (tilesize 30)
        for (int x = 0; x < width/30; x++) {
            tilePanes.put(x, new HashMap<>());
            for (int y = 0; y < height/30; y++) {
                TileStackPane tilelayout = new TileStackPane(x, y, this.gamelogic.getMinesNearAsStringForTile(x, y));
                
                tilelayout.setOnMouseClicked((event) -> {                   
                    if (event.getButton().equals(MouseButton.SECONDARY)) {
                        boolean flagged = this.gamelogic.flagTile(tilelayout.getX(), tilelayout.getY());
                        tilelayout.flag(flagged);
                    } else {
                        boolean opened = this.gamelogic.openTile(tilelayout.getX(), tilelayout.getY());                      
                        if (opened) {
                            tilelayout.open();
                            if (tilelayout.getMinesNeartext().isEmpty()) {
                                Map<String, List<Integer>> toOpen = this.gamelogic.openEmptyTiles(tilelayout.getX(), tilelayout.getY());
                                while (!toOpen.get("x").isEmpty()) {
                                    TileStackPane openable = this.tilePanes.get(toOpen.get("x").get(0)).get(toOpen.get("y").get(0));
                                    openable.open();
                                    if (openable.getMinesNeartext().isEmpty()) {
                                        Map<String, List<Integer>> toOpenNew = this.gamelogic.openEmptyTiles(openable.getX(), openable.getY());
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
                                stage.setScene(this.losescene);
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
        
        return new Scene(gamelayout);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Field field = new Field(16, 16, 40);
        this.gamelogic = new GameLogic(field);
        
        this.tilePanes = new HashMap<>();
        
        this.menuscene = createMenuscene(480, 480, primaryStage);
        this.losescene = createLosescene(480, 480, primaryStage);
        this.winscene = createWinscene(480, 480, primaryStage)
        this.gamescene = createGamescene(480, 480, primaryStage);
    
        //winlayout

        //TODO: Score and database
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(this.menuscene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        
        launch(MinesweeperUI.class);
    }
}
