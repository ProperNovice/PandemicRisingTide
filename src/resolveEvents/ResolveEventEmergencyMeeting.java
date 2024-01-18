package resolveEvents;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.GetERegionContainingPlayerPawn;
import functions.MovePawnToRegion;
import gameStatesDefault.GameState;
import model.Actions;

public class ResolveEventEmergencyMeeting extends GameState {

	private ERegion eRegionActive = null, eRegionPassive = null;

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

		this.eRegionActive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		this.eRegionPassive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnPassive();

		this.eRegionActive.getRegion().setSelected();
		this.eRegionPassive.getRegion().setSelected();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		if (eRegion.equals(this.eRegionActive)) {

			MovePawnToRegion.INSTANCE.setUpERegionToMove(this.eRegionPassive);
			MovePawnToRegion.INSTANCE.moveToERegionActivePlayer();

		} else if (eRegion.equals(this.eRegionPassive)) {

			MovePawnToRegion.INSTANCE.setUpERegionToMove(this.eRegionActive);
			MovePawnToRegion.INSTANCE.moveToERegionPassivePlayer();

		}

		proceedToNextGameState();

	}

}
