package monsters;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Game;
import player.Player;

//decreasing score
public class Ghost extends Monster{
	public void addMonster(GridPane gamePane){
		if(getNumberOfmonsters()==8)
			setMonsterImage(new ImageView(new Image("/images/ghostEasy.png")));
		else if (getNumberOfmonsters()==15)
			setMonsterImage(new ImageView(new Image("/images/ghostMedium.png")));
		else if (getNumberOfmonsters()==30)
			setMonsterImage(new ImageView(new Image("/images/ghostHard.png")));
		while(Game.gameGroundCellAvilability(gamePane, getCol(), getRow())){
			setRow((int) (0+(Math.random()*(Game.gameGroundSize(gamePane)-0))));
			setCol((int) (2+(Math.random()*(Game.gameGroundSize(gamePane)-2))));
		}
	}
	   public void monsterAction() {
			Player.getInstance().setScore(Player.getInstance().getScore()-5);
	 }
	
	

}
