/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabsmediaplayer;

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Marc Tabia
 */
public class TabsMediaPlayer extends Application {
    
    Player player;
    FileChooser fileChooser;
    
    @Override
    public void start(final Stage primaryStage) {
       
       MenuItem open = new MenuItem("Open");
       Menu file = new Menu("File");
       MenuBar menu = new MenuBar();
       fileChooser = new FileChooser();
       
       file.getItems().add(open);
       menu.getMenus().add(file);
       
       open.setOnAction(new EventHandler<ActionEvent>() {

           @Override
           public void handle(ActionEvent event) {
               player.player.pause();
               File file = fileChooser.showOpenDialog(primaryStage);
               if (file != null) {
                   try {
                       
                       player = new Player(
                           file.toURI().toURL().toExternalForm());
                       player.setTop(menu);
                       Scene scene = new Scene(player, 720, 535, Color.BLACK);
                       primaryStage.setScene(scene);
                       primaryStage.show();
                       
                   } catch (MalformedURLException e1) {
                       e1.printStackTrace();
                   }
               }
           }
           
       });
        
       player = new Player("file:///C:/gimp.mp4");
       player.setTop(menu);
       
       Scene scene = new Scene(player, 720, 535, Color.BLACK);
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
