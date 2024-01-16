package resolveEvents;

import functions.SkipDikesFailStepThisTurn;
import gameStatesDefault.GameState;

public class ResolveEventEmergencySandbags extends GameState {

	@Override
	public void execute() {

		SkipDikesFailStepThisTurn.INSTANCE.execute();
		proceedToNextGameState();

	}

}
