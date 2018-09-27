package monsters;

import java.util.ArrayList;
import gifts.Coin;
import javafx.scene.layout.GridPane;
import model.Game;

public class MoveMonster {
	
	public static void moveMonster(Monster monster,int direction,GridPane gamePane,ArrayList<Coin> gifts
			,ArrayList<Monster> monsters){
		switch(direction){
		case 1:
			if(monster.getRow()-1>-1&&
					!Game.gameGroundCellAvilability(gamePane,monster.getCol(),monster.getRow()-1))
			{
					gamePane.getChildren().remove(monster.getMonsterImage());
					monster.setRow(monster.getRow()-1);
					gamePane.add(monster.getMonsterImage(),monster.getCol(), monster.getRow());
			}
		break;
		case 2:
			if(monster.getRow()+1<=Game.gameGroundSize(gamePane)&&
			!Game.gameGroundCellAvilability(gamePane,monster.getCol(),monster.getRow()+1))
			{
			
					gamePane.getChildren().remove(monster.getMonsterImage());
					monster.setRow(monster.getRow()+1);
					gamePane.add(monster.getMonsterImage(),monster.getCol(), monster.getRow());
			}
		break;
		case 3:
			if(monster.getCol()+1<Game.gameGroundSize(gamePane)&&
					!Game.gameGroundCellAvilability(gamePane,monster.getCol()+1,monster.getRow()))
			{
					gamePane.getChildren().remove(monster.getMonsterImage());
					monster.setCol(monster.getCol()+1);
					gamePane.add(monster.getMonsterImage(),monster.getCol(), monster.getRow());
			}
		break;
		case 4:
			if(monster.getCol()-1>-1&&
					!Game.gameGroundCellAvilability(gamePane,monster.getCol()-1,monster.getRow()))
				{
					gamePane.getChildren().remove(monster.getMonsterImage());
					monster.setCol(monster.getCol()-1);
					gamePane.add(monster.getMonsterImage(),monster.getCol(), monster.getRow());
				}
		break;
		}
	}
}
