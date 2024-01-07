package gameStates;

import functions.Flood;
import gameStatesDefault.GameState;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		Flood.INSTANCE.clearList();

	}

}
