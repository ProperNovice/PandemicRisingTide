package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.FRemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;

public class SelectWaterRegionsWithWaterPump extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.PUMP_WATER);

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		FRemoveWaterFromRegion.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

}
