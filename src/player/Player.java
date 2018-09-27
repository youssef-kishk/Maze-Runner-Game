package player;

import controller.GamePageController;

import javafx.scene.image.ImageView;
 

public class Player extends GamePageController{
	private static Player instance = new Player();
	private Player(){}
	public static Player getInstance(){
	      return instance;
	   }
	private ImageView playerImage;
	private static int numberOfShots=5;
	public static int getNumberOfShots() {
		return numberOfShots;
	}
	public static void setNumberOfShots(int numberOfShots) {
		Player.numberOfShots = numberOfShots;
	}
	private int row=0;
	private int col=1;
	private static int score=0;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		Player.score = score;
	}
	public  int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public  int getCol() {
		return col;
	}
	public  void setCol(int col) {
		this.col = col;
	}

	public ImageView getPlayerImage() {
			return playerImage;
		}
	public void setPlayerImage(ImageView playerImage) {
			this.playerImage = playerImage;
		}
}
	



