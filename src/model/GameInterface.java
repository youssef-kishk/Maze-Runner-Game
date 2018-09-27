package model;

import java.io.FileNotFoundException;

import javafx.scene.layout.GridPane;

public interface GameInterface {
	   public  void level(GridPane gamePane,int level) throws FileNotFoundException;
	   public  void displayPlayGround(GridPane gamePane,String s);
}
