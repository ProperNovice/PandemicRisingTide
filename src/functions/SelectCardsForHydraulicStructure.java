package functions;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EColor;
import enums.ERegion;
import model.Players;

public enum SelectCardsForHydraulicStructure {

	INSTANCE;

	public void execute() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		EColor eColor = eRegion.getRegion().getEColor();

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!cardPlayerRegion.getEColor().equals(eColor))
				continue;

			cardPlayerRegion.setSelected();

		}

	}

}
