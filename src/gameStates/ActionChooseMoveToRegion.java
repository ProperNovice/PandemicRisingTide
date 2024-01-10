package gameStates;

import enums.EAction;
import functions.FSetUpMoveTargetRegions;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionChooseMoveToRegion extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.MOVE);
		FSetUpMoveTargetRegions.INSTANCE.execute();
		
		

	}

}
