package gameStates;

import functions.Flood;
import functions.SelectPumpingStationsAvailableToOperate;
import functions.SkipDikesFailStepThisTurn;
import gameStatesDefault.GameState;
import model.Players;

public class StartNewTurn extends GameState {

	@Override
	public void execute() {

		SelectPumpingStationsAvailableToOperate.INSTANCE.startNewTurn();

		Players.INSTANCE.changePlayerOrder();
		Players.INSTANCE.getActivePlayer().resetActionsRemaining();

		for (int counter = 1; counter <= 4; counter++) {

			getFlow().addLast(ActionChoose.class);
			getFlow().addLast(ActionsRemainingReduce.class);

		}

		SkipDikesFailStepThisTurn.INSTANCE.execute();
		Flood.INSTANCE.clearList();

	}

}
