package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;

public class ResolveStorm extends GameState {

	@Override
	public void execute() {
		EAction.STORM.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

	}

}
