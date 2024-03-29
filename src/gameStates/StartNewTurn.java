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

		SkipDikesFailStepThisTurn.INSTANCE.reset();
		Flood.INSTANCE.clearList();

		getFlow().addLast(ActionChoose.class);
		getFlow().addLast(ActionEnded.class);

		getFlow().addLast(ActionOperatePumps.class);
		getFlow().addLast(ActionDrawTwoPlayerCards.class);
		getFlow().addLast(ActionDikesFail.class);
		getFlow().addLast(ActionWaterFlows.class);

		getFlow().addLast(StartNewTurn.class);

		proceedToNextGameState();

	}

}
