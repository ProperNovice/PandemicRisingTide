package resolveEvents;

import gameStatesDefault.GameState;
import model.Players;

public class ResolveEventEngineeringCorps extends GameState {

	@Override
	public void execute() {

		Players.INSTANCE.getActivePlayer().addActionsRemaining(3);
		proceedToNextGameState();

	}

}
