package monsters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Game;

public class KillingMonster extends Monster{
	public void addMonster(GridPane gamePane){
		if(getNumberOfmonsters()==8)
			setMonsterImage(new ImageView(new Image("/images/monsterEasy.jpg")));
		else if (getNumberOfmonsters()==15)
			setMonsterImage(new ImageView(new Image("/images/monsterMedium.jpg")));
		else if (getNumberOfmonsters()==30)
			setMonsterImage(new ImageView(new Image("/images/monsterHard.jpg")));
		while(Game.gameGroundCellAvilability(gamePane, getCol(), getRow())){
			setRow((int) (0+(Math.random()*(Game.gameGroundSize(gamePane)-0))));
			setCol((int) (2+(Math.random()*(Game.gameGroundSize(gamePane)-2))));
		}
	}
	   public void monsterAction() {
		   System.exit(0);
		 }
}
