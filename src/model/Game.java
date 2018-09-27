package model;
import java.lang.reflect.Method;
import java.util.ArrayList;
import gifts.Coin;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import monsters.Monster;
public abstract class Game implements GameInterface{
		private static String difficulty="";
		public static int level=1;
 public static String getDifficulty() {
		return difficulty;
	}
	public static void setDifficulty(String difficulty) {
		Game.difficulty = difficulty;
	}

	   public static int gameGroundSize(GridPane gamePane){
			Method method;
			try {
				method = gamePane.getClass().getDeclaredMethod("getNumberOfRows");
				method.setAccessible(true);
				Integer rows = (Integer) method.invoke(gamePane);
				return rows;
			} catch (Exception e) {}
			return 0;

	   }
	   
	   @SuppressWarnings("static-access")
	public static boolean gameGroundCellAvilability(GridPane gamePane,int col,int row){
		   		@SuppressWarnings("unused")
				Node result = null;
		   		ObservableList<Node> childrens = gamePane.getChildren();
			    for (Node node : childrens) {
			    	//not emty
			         if (gamePane.getColumnIndex(node) == col && gamePane.getRowIndex(node) == row){
				            return true;
				        }
			    }
			    //empty
			    return false;
	   }
	   
	   @SuppressWarnings({ "unused", "static-access" })
	public static boolean movingPlayerPlaceCheck(GridPane gamePane,int col,int row,ArrayList<Coin> coin		   											,ArrayList<Monster> monsters){
	   		Node result = null;
	   		ObservableList<Node> childrens = gamePane.getChildren();
		    for (Node node : childrens) {
		    	//not emty
		         if (gamePane.getColumnIndex(node) == col && gamePane.getRowIndex(node) == row){
		 	         if (Coin.checkCoinPresence(coin, col, row)){
		 	        	 	Coin.presence=1;
		 		        	return false;
		 	         }
		 	         else if (Monster.checkMonsterPresence(monsters, col, row)){
		 	        	Monster.presence=1;
	 		        	return false;
		 	        }
			            return true;
			     }
		    }
		    //empty
		    Coin.presence=0;
		    Monster.presence=0;
		    return false;
	   }
	   
}
