package gameStates;

import enums.ERegion;
import functions.GetERegionContainingPlayerPawn;
import functions.PlayerHasCardWithERegion;
import gameStatesDefault.GameState;

public class ActionShareResources extends GameState {

	private ERegion eRegion = null;

	@Override
	public void execute() {

		this.eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

	}

	private boolean canGiveCard() {
		return PlayerHasCardWithERegion.INSTANCE.playerActiveHasCardWithERegion(this.eRegion);
	}

	private boolean canTakeCard() {
		return PlayerHasCardWithERegion.INSTANCE.playerPassiveHasCardWithERegion(this.eRegion);
	}

}
