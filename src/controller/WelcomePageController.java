package controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class WelcomePageController{

	@FXML
	public Pane welcomeWindowPane;
	@FXML
	public Pane gameOptionsPane;
	@FXML
	private Button newGame;
	@FXML
	public void loadSecond() throws IOException{
		gameOptionsPane=FXMLLoader.load(getClass().getResource("/GameOptionsPage.fxml"));
		welcomeWindowPane.getChildren().setAll(gameOptionsPane);
	}
}
