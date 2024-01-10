package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;

public class ActionPumpWaterFromPlayerActiveRegion extends GameState {

	@Override
	public void execute() {

		EAction.PUMP_WATER.show();

	}

}
