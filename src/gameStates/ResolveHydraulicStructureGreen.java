package gameStates;

import business.Region;
import enums.EAction;
import enums.EColor;
import enums.ERegion;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;
import utils.SelectImageViewManager;

public class ResolveHydraulicStructureGreen extends GameState {

	private int removeWaterCubes = 6, availableRegions;

	@Override
	public void execute() {

		selectAvailableRegions();
		EAction.PUMP_WATER.showAndSelect();

		if (this.removeWaterCubes == 0 || this.availableRegions == 0)
			proceed();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		proceed();
	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		RemoveWaterFromRegion.INSTANCE.execute(eRegion);
		this.removeWaterCubes--;
		execute();

	}

	private void selectAvailableRegions() {

		this.availableRegions = 0;

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getEColor() == null)
				continue;

			if (!region.getEColor().equals(EColor.GREEN))
				continue;

			if (region.getWaterCubes().getArrayList().isEmpty())
				continue;

			this.availableRegions++;
			region.setSelected();

		}

	}

	private void proceed() {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

}
