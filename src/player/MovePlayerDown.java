package player;

import java.util.ArrayList;

import gifts.Coin;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.Game;
import monsters.Monster;

public class MovePlayerDown implements MovePlayer{
	public void movePlayer(GridPane gamePane,Player player,KeyEvent e,ArrayList<Coin> gifts
													,ArrayList<Monster> monsters){
		if(player.getRow()+1<=Game.gameGroundSize(gamePane)&&
				!Game.movingPlayerPlaceCheck(gamePane,player.getCol(),player.getRow()+1,gifts,monsters))
		{
				
			gamePane.getChildren().remove(Player.getInstance().getPlayerImage());
			player.setRow(player.getRow()+1);
			gamePane.add(Player.getInstance().getPlayerImage(),player.getCol(), player.getRow());
			for(int i=0;i<monsters.size();i++){
				monsters.get(i).moveMonster(monsters.get(i), gamePane, gifts, monsters);
				
			}
		}	
		MoveFactory.coinOrMonsterPresnce(gamePane, player, e, gifts, monsters);
	}
}
