package resolveEvents;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.GetRegionsContainingAtLeastOneWaterCube;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;
import utils.ArrayList;

public class ResolveEventHoogheemraadschappen extends GameState {

	private int waterCubesToRemove = 3;
	private ArrayList<Region> list = null;

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

		this.list = GetRegionsContainingAtLeastOneWaterCube.INSTANCE.execute();

		if (this.list.isEmpty()) {

			proceedToNextGameState();
			return;

		}

		int waterCubesTotal = 0;

		for (Region region : this.list)
			waterCubesTotal += region.getWaterCubes().getArrayList().size();

		if (waterCubesTotal <= this.waterCubesToRemove)
			handleRegionSelectedPressed(null, this.list.getFirst());

		else
			for (Region region : this.list)
				region.setSelected();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		this.waterCubesToRemove--;
		RemoveWaterFromRegion.INSTANCE.execute(region);

		if (this.waterCubesToRemove > 0)
			execute();
		else
			proceedToNextGameState();

	}

}
