package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.GetERegionContainingPlayerPawn;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ActionPumpWaterFromActiveOrAdjacentRegion extends GameState {

	private ArrayList<ERegion> list = new ArrayList<>();

	@Override
	public void execute() {

		setUpRegions();
		EAction.PUMP_WATER.show();

		if (this.list.size() > 1)
			return;
		else
			handleRegionSelectedPressed(this.list.getFirst(), this.list.getFirst().getRegion());

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		RemoveWaterFromRegion.INSTANCE.execute(eRegion);
		proceedToNextGameState();

	}

	private void setUpRegions() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		eRegion.getRegion().setSelected();

		this.list.addLast(eRegion);

		for (ERegion eRegionTemp : Adjacencies.INSTANCE.getAdjacentERegions(eRegion)) {

			Region regionTemp = eRegionTemp.getRegion();

			if (regionTemp.isSea())
				continue;

			if (regionTemp.getWaterCubes().getArrayList().isEmpty())
				continue;

			regionTemp.setSelected();
			this.list.addLast(eRegionTemp);

		}

	}

}
