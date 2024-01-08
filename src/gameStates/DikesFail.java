package gameStates;

import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.AddWaterToRegion;
import functions.Flood;
import functions.RemoveDike;
import functions.SetDikesAvailableToFail;
import gameStatesDefault.GameState;
import model.Actions;
import model.DiscardPileDikeFailure;
import model.Regions;
import utils.Flow;
import utils.SelectImageViewManager;

public abstract class DikesFail extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.DIKES_FAIL);

		if (SetDikesAvailableToFail.INSTANCE.sizeDikesAvailableToFail() > 0)
			SetDikesAvailableToFail.INSTANCE.selectDikesAvailableToFail();

		else
			Actions.INSTANCE.selectAction(EAction.DIKES_FAIL);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

		ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();
		Region region = Regions.INSTANCE.getRegion(eRegion);

		int waterCubes = region.getWaterCubes().getArrayList().size();

		if (waterCubes < 3) {

			waterCubes++;
			AddWaterToRegion.INSTANCE.execute(eRegion);

			if (region.getWaterCubes().getArrayList().isMaxCapacity() && !floodCanTrigger())
				removeDikesFailGameStatesFromFlow();
			

		} else {

			Flood.INSTANCE.execute(eRegion);
			removeDikesFailGameStatesFromFlow();

		}

		proceedToNextGameState();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

		RemoveDike.INSTANCE.execute(dikeLocation);
		proceedToNextGameState();

	}

	private void removeDikesFailGameStatesFromFlow() {

		while (Flow.INSTANCE.getFlow().getFirst().equals(DikesFailNoFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

		while (Flow.INSTANCE.getFlow().getFirst().equals(DikesFailWithFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

	}

	protected abstract boolean floodCanTrigger();

}
