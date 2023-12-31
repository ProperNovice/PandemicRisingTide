package gameStates;

import business.WaterPump;
import gameStatesDefault.GameState;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);

		new WaterPump();

	}

}
