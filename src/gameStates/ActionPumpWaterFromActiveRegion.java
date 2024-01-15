package gameStates;

import enums.ERegion;
import functions.GetERegionContainingPlayerPawn;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;

public class ActionPumpWaterFromActiveRegion extends GameState {

	@Override
	public void execute() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		RemoveWaterFromRegion.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

}
