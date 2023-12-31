package gameStates;

import enums.EAction;
import functions.FWaterFlows;
import gameStatesDefault.GameState;
import model.Actions;

public class WaterFlows extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.WATER_FLOWS);
		Actions.INSTANCE.selectAction(EAction.WATER_FLOWS);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		Actions.INSTANCE.concealActions();
		FWaterFlows.INSTANCE.execute();
		proceedToNextGameState();

	}

}
