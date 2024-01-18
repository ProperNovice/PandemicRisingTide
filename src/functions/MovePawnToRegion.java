package functions;

import business.Pawn;
import business.Player;
import business.Region;
import enums.ERegion;
import enums.ERole;
import model.Pawns;
import model.Players;

public enum MovePawnToRegion {

	INSTANCE;

	private ERegion eRegionTo = null;

	public void moveToERegionActivePlayer() {

		ERegion eRegionPlayer = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		moveToERegionPlayer(eRegionPlayer, Players.INSTANCE.getActivePlayer());

	}

	public void moveToERegionPassivePlayer() {

		ERegion eRegionPlayer = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnPassive();

		moveToERegionPlayer(eRegionPlayer, Players.INSTANCE.getPassivePlayer());

	}

	public void setUpERegionToMove(ERegion eRegionTo) {
		this.eRegionTo = eRegionTo;
	}

	public ERegion getERegionMoveTo() {
		return this.eRegionTo;
	}

	private void moveToERegionPlayer(ERegion eRegionFrom, Player player) {

		Region regionFrom = eRegionFrom.getRegion();
		Region regionTo = this.eRegionTo.getRegion();

		ERole eRole = player.getCardRole().getArrayList().getFirst().getERole();
		Pawn pawn = Pawns.INSTANCE.getPawn(eRole);

		regionFrom.getPawns().getArrayList().remove(pawn);
		regionTo.getPawns().getArrayList().addLast(pawn);

		regionFrom.getPawns().relocateImageViews();
		regionTo.getPawns().relocateImageViews();

	}

}
