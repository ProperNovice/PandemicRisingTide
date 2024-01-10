package gameStates;

import gameStatesDefault.GameState;
import model.Players;

public class ActionsRemainingReduce extends GameState {

	@Override
	public void execute() {

		Players.INSTANCE.getActivePlayer().reduceActionsRemaining();
		proceedToNextGameState();

	}

}
