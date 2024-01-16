package resolveEvents;

import business.Region;
import enums.EAction;
import enums.ERegion;
import gameStatesDefault.GameState;
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

	}

	private void handleAction() {

		EAction.RESOLVE_EVENT.show();
		this.list.getFirst().show();

		if (this.list.getFirst().equals(EAction.ARROWS_UP))
			handleActionArrowUp();
		else if (this.list.getFirst().equals(EAction.ARROWS_DOWN))
			handleActionArrowDown();

	}

	private void handleActionArrowUp() {

	}

	private void handleActionArrowDown() {

	}

}
