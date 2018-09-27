package view;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import controller.GamePageController;
import controller.OptionsPageController;
import gifts.Coin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.EasyGame;
import model.Game;
import model.HardGame;
import model.MediumGame;
import monsters.Ghost;
import monsters.KillingMonster;
import monsters.Monster;
import player.Player;

public class GameView {
	public void levelDesign(GridPane gamePane,int check,ArrayList<Coin>gifts,ArrayList<Monster>monsters) throws FileNotFoundException{
		gamePane.requestFocus();
		//singleton DP applied
		Game game = null;
		if(Game.getDifficulty().equals("easy")||Game.getDifficulty().equals("")){
			 game = EasyGame.getInstance();
			 Game.setDifficulty("easy");
			addPlayerToGame(gamePane,new Image("/images/player1Easy.png"),new Image("/images/player2Easy.png"));
		}
		else if (Game.getDifficulty().equals("medium")){
			game = MediumGame.getInstance();
			 Game.setDifficulty("medium");
			addPlayerToGame(gamePane,new Image("/images/player1medium.png"),new Image("/images/player2medium.png"));
		}
		else if (Game.getDifficulty().equals("hard")){
			game = HardGame.getInstance();
			Game.setDifficulty("hard");
			addPlayerToGame(gamePane,new Image("/images/player1Hard.png"),new Image("/images/player2Hard.png"));
			}
			game.level(gamePane,Game.level);	
			gifts(gamePane,gifts);
			monsters( gamePane,monsters,gifts);
	}
	private void addPlayerToGame(GridPane gamePane,Image player1Image,Image player2Image){
		Player player = Player.getInstance();
		player.setScore(GamePageController.tempScore);
		//handling not choosing player
		try{
		if(OptionsPageController.player.equals("player1"))
			player.setPlayerImage(new ImageView(player1Image));
		else if (OptionsPageController.player.equals("player2"))
			player.setPlayerImage(new ImageView(player2Image));
		gamePane.add(player.getPlayerImage(), player.getCol(), player.getRow());
		}
		catch(Exception ex){
			player.setPlayerImage(new ImageView(player1Image));
			gamePane.add(player.getPlayerImage(), player.getCol(), player.getRow());
		}
		
	}
	private void gifts(GridPane gamePane,ArrayList<Coin>gifts){
		for(int i=0;i<Coin.getNumberOfCoins();i++){
			gifts.add(new Coin());
			gifts.get(i).addGift(gamePane);
			gamePane.add(gifts.get(i).getCoinImage(), gifts.get(i).getCol(),gifts.get(i).getRow());
		}
	}
	private void monsters(GridPane gamePane,ArrayList<Monster>monsters,ArrayList<Coin> gifts){
		for(int i=0;i<Monster.getNumberOfmonsters();i++){
			if(i%2==0)
				monsters.add(new Ghost());			
			else 
				monsters.add(new KillingMonster());
			monsters.get(i).addMonster(gamePane);
			gamePane.add(monsters.get(i).getMonsterImage(), monsters.get(i).getCol(),monsters.get(i).getRow());
		}
	}
}
