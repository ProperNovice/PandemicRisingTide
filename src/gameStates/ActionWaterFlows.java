package gameStates;

import enums.EAction;
import functions.WaterFlows;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionWaterFlows extends GameState {

	@Override
	public void execute() {

		EAction.WATER_FLOWS.showAndSelect();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		Actions.INSTANCE.concealActions();
		WaterFlows.INSTANCE.execute();
		proceedToNextGameState();

	}

}
