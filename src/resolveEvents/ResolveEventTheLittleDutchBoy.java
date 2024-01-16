package resolveEvents;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.SetERegionProtectedFromWaterFlows;
import gameStatesDefault.GameState;
import model.Actions;

public class ResolveEventTheLittleDutchBoy extends GameState {

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			region.setSelected();

		}

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		SetERegionProtectedFromWaterFlows.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

}
