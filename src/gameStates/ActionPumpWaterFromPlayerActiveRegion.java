package gameStates;

import enums.ERegion;
import functions.FGetERegionContainingPlayerPawn;
import functions.FRemoveWaterFromRegion;
import gameStatesDefault.GameState;

public class ActionPumpWaterFromPlayerActiveRegion extends GameState {

	@Override
	public void execute() {

		ERegion eRegion = FGetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		FRemoveWaterFromRegion.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

}
