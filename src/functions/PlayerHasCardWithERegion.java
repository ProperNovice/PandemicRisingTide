package functions;

import business.Player;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import model.Players;

public enum PlayerHasCardWithERegion {

	INSTANCE;

	public boolean playerActiveHasCardWithERegion(ERegion eRegion) {
		return playerHasCardWithERegion(eRegion, Players.INSTANCE.getActivePlayer()) != null;
	}

	public boolean playerPassiveHasCardWithERegion(ERegion eRegion) {
		return playerHasCardWithERegion(eRegion, Players.INSTANCE.getPassivePlayer()) != null;
	}

	public CardPlayer getPlayerActiveCardWithERegion(ERegion eRegion) {
		return playerHasCardWithERegion(eRegion, Players.INSTANCE.getActivePlayer());
	}

	public CardPlayer getPlayerPassiveCardWithERegion(ERegion eRegion) {
		return playerHasCardWithERegion(eRegion, Players.INSTANCE.getPassivePlayer());
	}

	private CardPlayer playerHasCardWithERegion(ERegion eRegion, Player player) {

		for (CardPlayer cardPlayer : player.getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (cardPlayerRegion.getERegion().equals(eRegion))
				return cardPlayer;

		}

		return null;

	}

}
