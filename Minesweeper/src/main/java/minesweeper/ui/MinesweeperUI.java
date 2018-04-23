
package minesweeper.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import minesweeper.domain.Field;


public class MinesweeperUI extends Application{

    //Organise parts to own methods later?
    @Override
    public void start(Stage primaryStage) {
        //Field
        //GameLogic
        
        BorderPane menulayout = new BorderPane();
        GridPane gamelayout = new GridPane();
        
        //menulayout
        Label menutitle = new Label("Minesweeper");
        Button newgamebutton = new Button("New Game");
        
        menulayout.setTop(menutitle);
        menulayout.setCenter(newgamebutton);
        menulayout.setPrefSize(300, 200);
        
        //gamelayout
        Label temporaryinfo = new Label("The actual game will be added here later");
        Button returntomenu = new Button("Return to menu");
        
        gamelayout.add(temporaryinfo, 0, 0);
        gamelayout.add(returntomenu, 0, 2);
        gamelayout.setPrefSize(300, 200);
        gamelayout.setVgap(5);
        gamelayout.setHgap(5);
        gamelayout.setAlignment(Pos.CENTER);
        
        //scenes
        Scene menuscene = new Scene(menulayout);
        Scene gamescene = new Scene(gamelayout);
        
        //buttons
        newgamebutton.setOnAction((event) -> {
            primaryStage.setScene(gamescene);
        });
        
        returntomenu.setOnAction((event)-> {
            primaryStage.setScene(menuscene);
        });
        
        primaryStage.setScene(menuscene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        
        launch(MinesweeperUI.class);
    }
}
