package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import gifts.Coin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Game;
import monsters.Monster;
import player.MoveFactory;
import player.Player;
import player.PlayerFire;
import view.GameView;
public class GamePageController{
	@FXML
	public GridPane gamePane;
	int check=0;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<Coin> gifts = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<Monster> monsters = new ArrayList();
	@FXML
	public void initialize(){
		new Coin().addGiftFeatures();		
		Monster.addMonstersFeatures();
	}
	public void levelDesign() throws FileNotFoundException{
		if(check==0){
			check=1;
			new GameView().levelDesign(gamePane, check, gifts,monsters);

		}
	}
	int lastMovement=0;
	@SuppressWarnings("incomplete-switch")
	@FXML
	public void move(KeyEvent e) throws IOException{
	if(stopMovenemt==0){
		switch(e.getCode()){
		case UP:
			lastMovement=1;
			MoveFactory.direction("up", gamePane, Player.getInstance(), e, gifts,monsters,wonPane);
		break;
		case DOWN:
			lastMovement=2;
			MoveFactory.direction("down", gamePane, Player.getInstance(), e, gifts,monsters,wonPane);
		break;
		case RIGHT:
			lastMovement=3;
			MoveFactory.direction("right", gamePane, Player.getInstance(), e, gifts,monsters,wonPane);
		break;	
		case LEFT:
			lastMovement=4;
			MoveFactory.direction("left", gamePane, Player.getInstance(), e, gifts,monsters,wonPane);
		break;
		case SPACE:
			if(Player.getNumberOfShots()>=0 ){
					PlayerFire.shotMonster(gamePane, lastMovement, monsters);
					TestMazeRunner.x.play("shot.mp3");
			}
		break;
			}
			checkWin(gamePane);
		}
	}
	int stopMovenemt=0;
private void checkWin(GridPane gamePane) throws IOException{
		if(Player.getInstance().getCol()==Game.gameGroundSize(gamePane)-1&&
				Player.getInstance().getRow()==Game.gameGroundSize(gamePane)-2){
			stopMovenemt=1;
			gamePane.getChildren().remove(wonPane);
			Player.getInstance().setScore(Player.getInstance().getScore()+10);
			tempScore=Player.getInstance().getScore();
			gameScore.setText("Score = ");
			gameScore.setText(gameScore.getText()+Player.getInstance().getScore());
			gamePane.getChildren().add(wonPane);
			wonPane.setVisible(true);
		}
	}
	@FXML
	private Button nextLevelButton;
	@FXML
	private Button exitButton;
	@FXML
	public Pane wonPane;
	@FXML
	public Text gameScore;
	@FXML
	public void exitButtonAction(ActionEvent e){
		System.exit(0);
	}
	public static int tempScore=0;
	@SuppressWarnings({ "unused", "static-access" })
	@FXML
	public void nextLevelButtonAction(ActionEvent e) throws IOException{
		stopMovenemt=0;
		Game game=null;
		Player player = Player.getInstance();
			player.setNumberOfShots(5);
			gamePane.getChildren().clear();
			player.setCol(1);
			player.setRow(0);
			Game.level++;
			if(Game.getDifficulty().equals("easy")&&Game.level==3){
				Game.setDifficulty("medium");
				Game.level=1;
			}
			else if(Game.getDifficulty().equals("medium")&&Game.level==3){
				Game.setDifficulty("hard");
				Game.level=1;
			}
			else if(Game.getDifficulty().equals("hard")&&Game.level==3){
				ImageView won = new ImageView("/images/winner.gif");
				won.setTranslateY(250);
				gamePane.getChildren().clear();
				gamePane.getChildren().add(won);
				gamePane.setStyle("-fx-background-color:black");
					check=-5;
			}
			gifts.clear();
			monsters.clear();
			new Coin().addGiftFeatures();		
			Monster.addMonstersFeatures();
			if(check!=-5){
				check=0;
				levelDesign();	
			}
	}
}