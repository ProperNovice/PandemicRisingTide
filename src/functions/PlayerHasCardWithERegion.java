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

	public CardPlayer removePlayerActiveCardWithERegion(ERegion eRegion) {
		return removeCardFromPlayer(eRegion, Players.INSTANCE.getActivePlayer());
	}

	public CardPlayer removePlayerPassiveCardWithERegion(ERegion eRegion) {
		return removeCardFromPlayer(eRegion, Players.INSTANCE.getPassivePlayer());
	}

	private CardPlayer removeCardFromPlayer(ERegion eRegion, Player player) {

		CardPlayer cardPlayer = playerHasCardWithERegion(eRegion, player);
		player.getCardsPlayer().getArrayList().remove(cardPlayer);

		return cardPlayer;

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
