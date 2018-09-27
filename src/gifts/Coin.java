package gifts;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Game;
import player.Player;

public class Coin implements GiftsInterface {
	public static int presence=0;
	private ImageView coinImage;
	private static int numberOfCoins;
	private int row=0;
	private int col=0;
	public static int getNumberOfCoins() {
		return numberOfCoins;
	}
	public ImageView getCoinImage() {
		return coinImage;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public void addGiftFeatures(){
		if(Game.getDifficulty().equals("easy")){
			numberOfCoins=8;
		}
		else if (Game.getDifficulty().equals("medium")){
			numberOfCoins=15;
			//coinImage=new ImageView(new Image("images/coinEasy.gif"));
		}
		else if (Game.getDifficulty().equals("hard")){
			numberOfCoins=30;
			//coinImage=new ImageView(new Image("images/coinEasy.gif"));
		}
	}

	public void addGift(GridPane gamePane){
		if(numberOfCoins==8)
			coinImage=new ImageView(new Image("/images/coinEasy.gif"));
		else if (numberOfCoins==15)
			coinImage=new ImageView(new Image("/images/coinMedium.gif"));
		else if (numberOfCoins==30)
			coinImage=new ImageView(new Image("/images/coinHard.gif"));
		while(Game.gameGroundCellAvilability(gamePane, col, row)){
			row = (int) (0+(Math.random()*(Game.gameGroundSize(gamePane)-0)));
			col = (int) (0+(Math.random()*(Game.gameGroundSize(gamePane)-0)));
		}
	}
	
	public static boolean checkCoinPresence(ArrayList<Coin> coin,int col,int row){
		for(int i=0;i<coin.size();i++){
			if(coin.get(i).getCol()==col&&coin.get(i).getRow()==row)
				return true;
		}
		return false;
	}
	
	public static void removeCoin(GridPane gamePane,ArrayList<Coin> coin,int col,int row,Player player){
		for(int i=0;i<coin.size();i++){
			if(coin.get(i).getCol()==col&&coin.get(i).getRow()==row){
				gamePane.getChildren().remove(coin.get(i).getCoinImage());
				coin.remove(i);
				player.setScore(player.getScore()+5);
			}
		}
	}

}


