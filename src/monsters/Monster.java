package monsters;

import java.util.ArrayList;

import gifts.Coin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Game;
import player.Player;

public abstract class Monster implements State{
	public static int presence=0;
	private ImageView monsterImage;
	private static int numberOfmonsters=0;
	private int row=0;
	private int col=0;
	public ImageView getMonsterImage() {
		return monsterImage;
	}
	public void setMonsterImage(ImageView monsterImage) {
		this.monsterImage = monsterImage;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public static int getPresence() {
		return presence;
	}
	public static int getNumberOfmonsters() {
		return numberOfmonsters;
	}
	
	public static void addMonstersFeatures(){
		if(Game.getDifficulty().equals("easy")||Game.getDifficulty().equals("")){
			numberOfmonsters=8;
		}
		else if (Game.getDifficulty().equals("medium")){
			numberOfmonsters=15;
		}
		else if (Game.getDifficulty().equals("hard")){
			numberOfmonsters=30;
		}
	}
	
	
	public static boolean checkMonsterPresence(ArrayList<Monster> monsters,int col,int row){
		for(int i=0;i<monsters.size();i++){
			if(monsters.get(i).getCol()==col&&monsters.get(i).getRow()==row)
				//found
				return true;
		}
		//not found
		return false;
	}
	
	public static void removeMonster(GridPane gamePane,ArrayList<Monster> monsters,int col,int row,Player player){
		for(int i=0;i<monsters.size();i++){
			if(monsters.get(i).getCol()==col&&monsters.get(i).getRow()==row){
				gamePane.getChildren().remove(monsters.get(i).getMonsterImage());
				player.setScore(player.getScore()+5);
				monsters.remove(i);
			}
		}
	}
	/*
	1->up
	2->down
	3->right
	4->left*/
	public void moveMonster(Monster monster,GridPane gamePane,ArrayList<Coin> gifts
			,ArrayList<Monster> monsters){
		int moveDirection = (int) (1+(Math.random()*4));
		MoveMonster.moveMonster(monster, moveDirection, gamePane, gifts, monsters);
	}
	
}
