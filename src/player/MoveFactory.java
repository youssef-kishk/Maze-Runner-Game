package player;

import java.util.ArrayList;

import controller.TestMazeRunner;
import gifts.Coin;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import monsters.Monster;

public class MoveFactory {
	   public static MoveFactory direction(String direction,GridPane gamePane,
			   						Player player,KeyEvent e,ArrayList<Coin> gifts,ArrayList<Monster>monsters,Pane wonPane){
		      if(direction.equalsIgnoreCase("up"))
		    	  new MovePlayerUP().movePlayer(gamePane, Player.getInstance(), e, gifts,monsters);	         
		      else if(direction.equalsIgnoreCase("down"))
		    	  new MovePlayerDown().movePlayer(gamePane, Player.getInstance(), e, gifts,monsters);    
		       else if(direction.equalsIgnoreCase("right"))
		    	  new MovePlayerRight().movePlayer(gamePane, Player.getInstance(), e, gifts,monsters);
		      else if(direction.equalsIgnoreCase("left"))
		    	  new MovePlayerLeft().movePlayer(gamePane, Player.getInstance(), e, gifts,monsters);	      
		      return null;
		}
		
		public static void coinOrMonsterPresnce(GridPane gamePane,Player player,KeyEvent e,ArrayList<Coin> gifts
				,ArrayList<Monster> monsters){
			if(Coin.presence==1){
				TestMazeRunner.x.play("coin.mp3");
				Coin.removeCoin(gamePane, gifts, player.getCol(), player.getRow(), player);
			}
			else if(Monster.presence==1){
				for(int i=0;i<monsters.size();i++){
					if(player.getCol()==monsters.get(i).getCol()&&player.getRow()==monsters.get(i).getRow()){
						monsters.get(i).monsterAction();
						gamePane.getChildren().remove(monsters.get(i).getMonsterImage());
						monsters.remove(i);
					}
				}
			}
		}
}
