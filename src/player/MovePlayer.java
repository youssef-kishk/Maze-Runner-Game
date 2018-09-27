package player;

import java.util.ArrayList;

import gifts.Coin;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import monsters.Monster;

public interface MovePlayer {
	public void movePlayer(GridPane gamePane,Player player,KeyEvent e,ArrayList<Coin> gifts,
										ArrayList<Monster> monsters);
}
