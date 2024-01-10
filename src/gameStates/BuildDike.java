package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;

public class BuildDike extends GameState {

	@Override
	public void execute() {

		EAction.BUILD_DIKE.show();

	}

}
