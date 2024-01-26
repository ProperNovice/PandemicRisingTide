package functions;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EColor;
import model.Players;
import utils.ArrayList;

public enum GetCardsPlayerHasWithEColor {

	INSTANCE;

	public ArrayList<CardPlayer> execute(EColor eColor) {

		ArrayList<CardPlayer> list = new ArrayList<>();

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!cardPlayerRegion.getEColor().equals(eColor))
				continue;

			list.addLast(cardPlayer);

		}

		return list;

	}

}
