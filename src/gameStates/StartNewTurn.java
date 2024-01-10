package gameStates;

import functions.SelectWaterPumpsAvailableToOperate;
import gameStatesDefault.GameState;
import model.Players;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		SelectWaterPumpsAvailableToOperate.INSTANCE.startNewTurn();

		Players.INSTANCE.changePlayerOrder();
		Players.INSTANCE.getActivePlayer().resetActionsRemaining();

		for (int counter = 1; counter <= 4; counter++) {

			getFlow().addLast(ActionChoose.class);
			getFlow().addLast(ActionsRemainingReduce.class);

		}

	}

}
