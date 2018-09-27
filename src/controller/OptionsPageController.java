package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Game;

public class OptionsPageController{
	@FXML
	private ComboBox<String> choosePlayer;
	@FXML
	private ImageView playerImage;
	@FXML
	private Button startGame;
	@FXML
	private ToggleButton easyGameButton;
	@FXML
	private ToggleButton mediumGameButton;
	@FXML
	private ToggleButton hardGameButton;
	public static String player;
	@FXML
    public void initialize(){
    		choosePlayer.getItems().setAll("player1","player2");
    }
	public void playerChoising(){
		if(choosePlayer.getValue().equals("player2")){
				playerImage.setImage(new Image("/images/player2.png"));
				player="player2";
		}
		else if(choosePlayer.getValue().equals("player1")){
				playerImage.setImage(new Image("/images/player1.png"));
				player="player1";
		}
	}
	public void setEasyGame(){
			Game.setDifficulty("easy");	
			easyGameButton.setTextFill(Color.DARKBLUE);
			mediumGameButton.setTextFill(Color.rgb(218, 6, 6));
			hardGameButton.setTextFill(Color.rgb(218, 6, 6));
	}
	public void setMediumGame(){
		Game.setDifficulty("medium");
		easyGameButton.setTextFill(Color.rgb(218, 6, 6));
		mediumGameButton.setTextFill(Color.DARKBLUE);
		hardGameButton.setTextFill(Color.rgb(218, 6, 6));
	}
	public void setHardGame(){
		Game.setDifficulty("hard");	
		easyGameButton.setTextFill(Color.rgb(218, 6, 6));
		mediumGameButton.setTextFill(Color.rgb(218, 6, 6));
		hardGameButton.setTextFill(Color.DARKBLUE);
	}
	public void startGameButtonAction() throws IOException{
		 	Parent root = FXMLLoader.load(getClass().getResource("/EasyMazeDesign.fxml"));
		 	TestMazeRunner.primaryStage=new Stage();
		 	TestMazeRunner.primaryStage.setScene(new Scene(root,1300,690));
		 	TestMazeRunner.primaryStage.setTitle("Maze-Runner");
		 	TestMazeRunner.primaryStage.setResizable(false);
		 	TestMazeRunner.primaryStage.show();
	}

}
