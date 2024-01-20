package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.SeaLevel;

public class SeaLevelsRise extends GameState {

	@Override
	public void execute() {
		EAction.SEA_LEVELS_RISE.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SeaLevel.INSTANCE.advance();
		proceedToNextGameState();

	}

}
