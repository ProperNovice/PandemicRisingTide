package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;

public class WaterFlows extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.WATER_FLOWS);

	}

	@Override
	public void handleActionPressed(EAction eAction) {

		Actions.INSTANCE.concealActions();
		functions.WaterFlows.INSTANCE.execute();
		proceedToNextGameState();

	}

}
