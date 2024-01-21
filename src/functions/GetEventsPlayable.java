package functions;

import business.Player;
import cards.CardPlayer;
import cards.CardPlayerEvent;
import model.Players;
import utils.ArrayList;

public enum GetEventsPlayable {

	INSTANCE;

	public ArrayList<CardPlayer> executeActivePlayer() {
		return execute(Players.INSTANCE.getActivePlayer());
	}

	public ArrayList<CardPlayer> executePassivePlayer() {
		return execute(Players.INSTANCE.getPassivePlayer());
	}

	private ArrayList<CardPlayer> execute(Player player) {

		ArrayList<CardPlayer> hand = player.getCardsPlayer().getArrayList().clone();
		ArrayList<CardPlayer> cardsToReturn = new ArrayList<>();

		for (CardPlayer cardPlayer : hand) {

			if (!(cardPlayer instanceof CardPlayerEvent))
				continue;

			if (!EventCanBeResolved.INSTANCE.execute(cardPlayer))
				continue;

			cardsToReturn.addLast(cardPlayer);

		}

		return cardsToReturn;

	}

}
