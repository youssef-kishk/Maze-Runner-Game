package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HardGame extends Game{
	//applying singleton DP
	 private static HardGame instance = new HardGame();
	   private HardGame(){}
	   public static HardGame getInstance(){
	      return instance;
	   }
	   public void level(GridPane gamePane,int level) throws FileNotFoundException{
			File fileEasy = new File("src/model/HardMazeFile.txt");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(fileEasy);
			in.useDelimiter("\n");
			String s = "";
			for(int i=0;i<level;i++){
				s = in.next().substring(11);
			}
			displayPlayGround(gamePane,s);
	}
	   public void displayPlayGround(GridPane gamePane,String s){
			 int row=0;
				int col = 0;
				String temp="";
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)=='('){
						while(s.charAt(i+1)!=',')
							temp+=s.charAt(++i);
						col=Integer.parseInt(temp);
					}
					else if(s.charAt(i)==','){
						while(s.charAt(i+1)!=')')
							temp+=s.charAt(++i);
						row=Integer.parseInt(temp);
						gamePane.add(new ImageView("/images/HardGameBlock.PNG"), col, row);
					}
					temp="";
				}
	   }
}
