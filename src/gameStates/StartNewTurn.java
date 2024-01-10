package gameStates;

import functions.FSelectWaterPumpsAvailableToOperate;
import gameStatesDefault.GameState;
import model.Players;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		FSelectWaterPumpsAvailableToOperate.INSTANCE.startNewTurn();

		Players.INSTANCE.changePlayerOrder();
		Players.INSTANCE.getActivePlayer().resetActionsRemaining();

	}

}
