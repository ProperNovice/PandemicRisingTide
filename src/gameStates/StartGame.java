package gameStates;

import enums.EText;
import gameStatesDefault.GameState;
import model.HydraulicStructures;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();
		HydraulicStructures.INSTANCE.reset();

	}

	@Override
	protected void executeTextOption(EText eText) {

	}

}
