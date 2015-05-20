/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabsmediaplayer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Marc Tabia
 */
public class Player extends BorderPane {
    
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBar bar;
    
    public Player(String file) {
        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mpane = new Pane();
        
        mpane.getChildren().add(view);
        
        setCenter(mpane);
        
        bar = new MediaBar(player);
        setBottom(bar);
        
        setStyle("-fx-background-color: #bfc2c7");
        
        player.play();
    }
    
}
