package gameStates;

import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.FAddWaterToRegion;
import functions.FFlood;
import functions.FRemoveDike;
import functions.FSetDikesAvailableToFail;
import gameStatesDefault.GameState;
import model.Actions;
import model.DiscardPileDikeFailure;
import model.Regions;
import utils.Flow;

public abstract class DegradeRegion extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.DIKES_FAIL);

		if (FSetDikesAvailableToFail.INSTANCE.sizeDikesAvailableToFail() > 0)
			FSetDikesAvailableToFail.INSTANCE.selectDikesAvailableToFail();

		else {

			ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();
			Region region = Regions.INSTANCE.getRegion(eRegion);
			region.setSelected();

		}

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		int waterCubes = region.getWaterCubes().getArrayList().size();

		if (waterCubes < 3) {

			waterCubes++;
			FAddWaterToRegion.INSTANCE.execute(eRegion);

			if (region.getWaterCubes().getArrayList().isMaxCapacity() && !floodCanTrigger())
				removeDikesFailGameStatesFromFlow();

		} else {

			FFlood.INSTANCE.execute(eRegion);
			removeDikesFailGameStatesFromFlow();

		}

		proceedToNextGameState();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();

		FRemoveDike.INSTANCE.execute(dikeLocation);
		proceedToNextGameState();

	}

	private void removeDikesFailGameStatesFromFlow() {

		while (Flow.INSTANCE.getFlow().getFirst().equals(DegradeRegionNoFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

		while (Flow.INSTANCE.getFlow().getFirst().equals(DegradeRegionWithFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

	}

	protected abstract boolean floodCanTrigger();

}
