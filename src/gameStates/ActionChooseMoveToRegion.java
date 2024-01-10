package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.FSetUpMoveTargetRegions;
import functions.PawnMoveToRegion;
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
		PawnMoveToRegion.INSTANCE.setUpERegionToMove(eRegion);

		if (FSetUpMoveTargetRegions.INSTANCE.getFreeERegions().contains(eRegion))
			PawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
		else
			getFlow().addFirst(ChooseCardToDiscardForMoving.class);

		proceedToNextGameState();

	}

}
