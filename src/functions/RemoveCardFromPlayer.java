package functions;

import business.Player;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import model.Players;
import utils.ShutDown;

public enum RemoveCardFromPlayer {

	INSTANCE;

	public CardPlayer executeActivePlayer(CardPlayer cardPlayer) {

		removeCardRelocate(cardPlayer, Players.INSTANCE.getActivePlayer());
		return cardPlayer;

	}

	public CardPlayer executeActivePlayer(ERegion eRegion) {

		CardPlayer cardPlayer = getCardPlayerRegion(eRegion, Players.INSTANCE.getActivePlayer());
		return executeActivePlayer(cardPlayer);

	}

	public CardPlayer executePassivePlayer(CardPlayer cardPlayer) {

		removeCardRelocate(cardPlayer, Players.INSTANCE.getPassivePlayer());
		return cardPlayer;

	}

	public CardPlayer executePassivePlayer(ERegion eRegion) {

		CardPlayer cardPlayer = getCardPlayerRegion(eRegion, Players.INSTANCE.getPassivePlayer());
		return executePassivePlayer(cardPlayer);

	}

	private void removeCardRelocate(CardPlayer cardPlayer, Player player) {

		player.getCardsPlayer().getArrayList().remove(cardPlayer);
		player.getCardsPlayer().relocateImageViews();

	}

	private CardPlayer getCardPlayerRegion(ERegion eRegion, Player player) {

		for (CardPlayer cardPlayer : player.getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (cardPlayerRegion.getERegion().equals(eRegion))
				return cardPlayer;

		}

		ShutDown.INSTANCE.execute();
		return null;

	}

}
