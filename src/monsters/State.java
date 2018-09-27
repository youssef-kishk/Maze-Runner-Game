package monsters;


import javafx.scene.layout.GridPane;

public interface State {
	public void addMonster(GridPane gamePane);
	public void monsterAction();
}
