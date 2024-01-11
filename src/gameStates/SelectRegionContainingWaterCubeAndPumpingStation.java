package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;

public class SelectRegionContainingWaterCubeAndPumpingStation extends GameState {

	@Override
	public void execute() {

		EAction.PUMP_WATER.show();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		RemoveWaterFromRegion.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

}
