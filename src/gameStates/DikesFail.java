package gameStates;

import business.DikeLocation;
import enums.EAction;
import enums.ERegion;
import functions.AddWaterToRegion;
import functions.Flood;
import functions.RemoveDike;
import functions.SetDikesAvailableToFail;
import gameStatesDefault.GameState;
import model.Actions;
import model.DiscardPileDikeFailure;
import utils.SelectImageViewManager;

public abstract class DikesFail extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.DIKES_FAIL);
		SetDikesAvailableToFail.INSTANCE.execute();

		if (!SetDikesAvailableToFail.INSTANCE.dikesAvailableToFail())
			Actions.INSTANCE.selectAction(EAction.DIKES_FAIL);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

		ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();
		AddWaterToRegion.INSTANCE.execute(eRegion, 1);

		if (floodCanTrigger())
			Flood.INSTANCE.execute(eRegion);

		proceedToNextGameState();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

		RemoveDike.INSTANCE.execute(dikeLocation);
		proceedToNextGameState();

	}

	protected abstract boolean floodCanTrigger();

}
