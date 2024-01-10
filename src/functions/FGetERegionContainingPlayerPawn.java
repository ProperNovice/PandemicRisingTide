package functions;

import business.Pawn;
import business.Player;
import business.Region;
import cards.CardRole;
import enums.ERegion;
import enums.ERole;
import model.Pawns;
import model.Players;
import utils.ShutDown;

public enum FGetERegionContainingPlayerPawn {

	INSTANCE;

	public ERegion getERegionContainingPlayerPawnActive() {
		return getERegionContainingPawn(Players.INSTANCE.getActivePlayer());
	}

	public ERegion getERegionContainingPlayerPawnPassive() {
		return getERegionContainingPawn(Players.INSTANCE.getPassivePlayer());
	}

	private ERegion getERegionContainingPawn(Player player) {

		CardRole cardRole = player.getCardRole().getArrayList().getFirst();
		ERole eRole = cardRole.getERole();
		Pawn pawn = Pawns.INSTANCE.getPawn(eRole);

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (!region.getPawns().getArrayList().contains(pawn))
				continue;

			return eRegion;

		}

		ShutDown.INSTANCE.execute();
		return null;

	}

}
