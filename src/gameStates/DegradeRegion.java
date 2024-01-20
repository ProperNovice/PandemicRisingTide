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
import utils.Flow;

public abstract class DegradeRegion extends GameState {

	private ERegion floodERegion = null;

	@Override
	public void execute() {

		EAction.DIKES_FAIL.show();

		if (SetDikesAvailableToFail.INSTANCE.sizeDikesAvailableToFail() > 0)
			SetDikesAvailableToFail.INSTANCE.selectDikesAvailableToFail();

		else {

			ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();
			Region region = eRegion.getRegion();
			region.setSelected();

		}

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		Flood.INSTANCE.execute(this.floodERegion);
		proceedToNextGameState();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		int waterCubes = region.getWaterCubes().getArrayList().size();

		if (waterCubes < 3) {

			waterCubes++;
			AddWaterToRegion.INSTANCE.execute(eRegion);

			if (region.getWaterCubes().getArrayList().isMaxCapacity() && !floodCanTrigger())
				removeDikesFailGameStatesFromFlow();

			proceedToNextGameState();

		} else {

			this.floodERegion = eRegion;
			EAction.FLOOD.showAndSelect();
			removeDikesFailGameStatesFromFlow();

		}

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();

		RemoveDike.INSTANCE.execute(dikeLocation);
		proceedToNextGameState();

	}

	private void removeDikesFailGameStatesFromFlow() {

		if (getFlow().isEmpty())
			return;

		while (Flow.INSTANCE.getFlow().getFirst().equals(DegradeRegionNoFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

		while (Flow.INSTANCE.getFlow().getFirst().equals(DegradeRegionWithFlood.class))
			Flow.INSTANCE.getFlow().removeFirst();

	}

	protected abstract boolean floodCanTrigger();

}
