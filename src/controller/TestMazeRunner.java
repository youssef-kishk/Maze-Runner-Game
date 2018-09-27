package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import music.AudioPlayer;

public class TestMazeRunner extends Application {
	public static AudioPlayer x;
	public static void main(String[] args) {
		Application.launch(args);
	}
	static Stage primaryStage;
	@Override
	public void start(Stage s) throws Exception {
		primaryStage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/WelcomePage.fxml"));
		primaryStage.setScene(new Scene(root,1065,630));
		primaryStage.setTitle("Maze-Runner");
		primaryStage.setResizable(false);
		primaryStage.show();		
		 x = new AudioPlayer();
		x.play("gameStart.mp3");

	}

}