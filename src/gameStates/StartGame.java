package gameStates;

import enums.ERegion;
import enums.EText;
import gameStatesDefault.GameState;
import model.HydraulicStructures;
import model.SeaLevel;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();
		HydraulicStructures.INSTANCE.reset();
		ERegion.ZUIDERZEE.getRegion().setIsSea(true);
		SeaLevel.INSTANCE.reset();

	}

	@Override
	protected void executeTextOption(EText eText) {

	}

}
