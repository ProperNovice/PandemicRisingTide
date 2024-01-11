package functions;

import business.Player;
import cards.CardPlayer;
import model.Players;

public enum RemoveCardFromPlayer {

	INSTANCE;

	public void executeActivePlayer(CardPlayer cardPlayer) {
		removeCardRelocate(cardPlayer, Players.INSTANCE.getActivePlayer());
	}

	public void executePassivePlayer(CardPlayer cardPlayer) {
		removeCardRelocate(cardPlayer, Players.INSTANCE.getPassivePlayer());
	}

	private void removeCardRelocate(CardPlayer cardPlayer, Player player) {

		player.getCardsPlayer().getArrayList().remove(cardPlayer);
		player.getCardsPlayer().relocateImageViews();

	}

}
