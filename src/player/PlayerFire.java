package player;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import model.Game;
import monsters.Monster;

public class PlayerFire {
	private static int gunRow;
	private static int gunCol;
	public static int getGunRow() {
		return gunRow;
	}
	public static void setGunRow(int gunRow) {
		PlayerFire.gunRow = gunRow;
	}
	public static int getGunCol() {
		return gunCol;
	}
	public static void setGunCol(int gunCol) {
		PlayerFire.gunCol = gunCol;
	}
	
	
	public static void shotMonster(GridPane gamePane,int lastMovement,ArrayList<Monster>monsters){
		Player.setNumberOfShots(Player.getNumberOfShots()-1);
		PlayerFire.setGunRow(Player.getInstance().getRow());
		PlayerFire.setGunCol(Player.getInstance().getCol());	
		switch(lastMovement){
			case 1:
				while(PlayerFire.getGunRow()!=0){
					PlayerFire.setGunRow(PlayerFire.getGunRow()-1);
				if(Monster.checkMonsterPresence(monsters, PlayerFire.getGunCol(),  PlayerFire.getGunRow())){
							Monster.removeMonster(gamePane, monsters, PlayerFire.getGunCol()
													,PlayerFire.getGunRow(),Player.getInstance());
							break;
					}
				}
			break;
			case 2:
				while(PlayerFire.getGunRow()!=Game.gameGroundSize(gamePane)){
					PlayerFire.setGunRow(PlayerFire.getGunRow()+1);
				if(Monster.checkMonsterPresence(monsters, PlayerFire.getGunCol(),  PlayerFire.getGunRow())){
							Monster.removeMonster(gamePane, monsters, PlayerFire.getGunCol()
													,PlayerFire.getGunRow(),Player.getInstance());
							break;
					}
				}
			break;
			case 3:
				while(PlayerFire.getGunCol()!=Game.gameGroundSize(gamePane)){
					PlayerFire.setGunCol(PlayerFire.getGunCol()+1);
				if(Monster.checkMonsterPresence(monsters, PlayerFire.getGunCol(),  PlayerFire.getGunRow())){
							Monster.removeMonster(gamePane, monsters, PlayerFire.getGunCol()
													,PlayerFire.getGunRow(),Player.getInstance());
							break;
					}
				}
			case 4:
				while(PlayerFire.getGunCol()!=0){
					PlayerFire.setGunCol(PlayerFire.getGunCol()-1);
				if(Monster.checkMonsterPresence(monsters, PlayerFire.getGunCol(),  PlayerFire.getGunRow())){
							Monster.removeMonster(gamePane, monsters, PlayerFire.getGunCol()
													,PlayerFire.getGunRow(),Player.getInstance());
							break;
					}
				}
			break;
		}
	}
	
	
}
