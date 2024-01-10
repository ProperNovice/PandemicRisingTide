package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.FPawnMoveToRegion;
import functions.FSetUpMoveTargetRegions;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionChooseMoveToRegion extends GameState {

	@Override
	public void execute() {

		EAction.MOVE.show();
		FSetUpMoveTargetRegions.INSTANCE.execute();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		FPawnMoveToRegion.INSTANCE.setUpERegionToMove(eRegion);

		if (FSetUpMoveTargetRegions.INSTANCE.getFreeERegions().contains(eRegion))
			FPawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
		else
			getFlow().addFirst(ChooseCardToDiscardForMoving.class);

		proceedToNextGameState();

	}

}
