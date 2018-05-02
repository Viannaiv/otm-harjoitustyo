
package minesweeper.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        
        BorderPane menulayout = new BorderPane();
        Pane gamelayout = new Pane();
        BorderPane endlayout = new BorderPane();
        
        //menulayout
        Label menutitle = new Label("Minesweeper");
        Button newgamebutton = new Button("New Game");
        
        menulayout.setTop(menutitle);
        menulayout.setCenter(newgamebutton);
        menulayout.setPrefSize(480, 480);
        
        //gamelayout
        gamelayout.setPrefSize(480, 480);
        
        //tilelayouts (tilesize 30)
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                StackPane tilelayout = new StackPane();
                
                tilelayout.setTranslateX(x * 30);
                tilelayout.setTranslateY(y * 30);
                
                Rectangle r = new Rectangle(28, 28); //change size here
                r.setFill(Color.DARKCYAN);
                
                Text mines = new Text(gamelogic.getMinesNearAsStringForTile((int)x, (int)y));
                mines.setVisible(false);
                
                Text flag = new Text("F");
                flag.setVisible(false);
                
                tilelayout.getChildren().addAll(r, mines, flag);
                
                tilelayout.setOnMouseClicked((event) -> {                   
                    if (event.getButton().equals(MouseButton.SECONDARY)) {
                        boolean flagged = gamelogic.flagTile((int)(tilelayout.getTranslateX() / 30), 
                                (int)(tilelayout.getTranslateY() / 30));
                        flag.setVisible(flagged);
                    } else {
                        boolean opened = gamelogic.openTile((int)(tilelayout.getTranslateX() / 30), 
                                (int)(tilelayout.getTranslateY() / 30));                      
                        if (opened) {
                            r.setFill(Color.LIGHTBLUE);
                            mines.setVisible(true);
                            flag.setVisible(false);
                        }
                        //TODO: open adjacent empty tiles here
                        //TODO: stop game when opening mined tile
                        //TODO: stop game on victory
                        //TODO: start with opened empty tiles or ´the first clicked tile not being a mined one
                    }
                }); //TODO: should it be so that flagged tiles cannot be opened?
                
                gamelayout.getChildren().add(tilelayout);
            }
        }
        
        //endlayout
        Text winmessage = new Text("Game over.");
        Text losemessage = new Text("You won.");
            //add the visible conditions
        
        endlayout.setCenter(winmessage);
        endlayout.setCenter(losemessage);
        endlayout.setPrefSize(480, 380);
            //Set a button for this and add event//
        
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
