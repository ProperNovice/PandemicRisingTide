package gameStates;

import functions.FSelectWaterPumpsAvailableToOperate;
import gameStatesDefault.GameState;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		FSelectWaterPumpsAvailableToOperate.INSTANCE.startNewTurn();

	}

}
