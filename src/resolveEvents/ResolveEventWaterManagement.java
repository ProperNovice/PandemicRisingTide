package resolveEvents;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.AddWaterToRegion;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;
import model.Actions;
import utils.ArrayList;

public class ResolveEventWaterManagement extends GameState {

	private ArrayList<EAction> list = new ArrayList<>();

	@Override
	public void execute() {

		this.list.addLast(EAction.ARROWS_UP, 3);
		this.list.addLast(EAction.ARROWS_DOWN, 3);

		handleAction();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		EAction eAction = this.list.removeFirst();

		if (eAction.equals(EAction.ARROWS_UP))
			handleRegionSelectedPressedUp(eRegion);
		else if (eAction.equals(EAction.ARROWS_DOWN))
			handleRegionSelectedPressedDown(eRegion);

	}

	private void handleRegionSelectedPressedUp(ERegion eRegion) {

		RemoveWaterFromRegion.INSTANCE.execute(eRegion);
		handleAction();

	}

	private void handleRegionSelectedPressedDown(ERegion eRegion) {

		AddWaterToRegion.INSTANCE.execute(eRegion);
		handleAction();

	}

	private void handleAction() {

		Actions.INSTANCE.concealActions();

		if (this.list.isEmpty()) {

			proceedToNextGameState();
			return;

		}

		EAction.RESOLVE_EVENT.show();

		this.list.getFirst().show();

		if (this.list.getFirst().equals(EAction.ARROWS_UP))
			handleActionArrowUp();
		else if (this.list.getFirst().equals(EAction.ARROWS_DOWN))
			handleActionArrowDown();

	}

	private void handleActionArrowUp() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (region.getWaterCubes().getArrayList().isEmpty())
				continue;

			region.setSelected();

		}

	}

	private void handleActionArrowDown() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			region.setSelected();

		}

	}

}
