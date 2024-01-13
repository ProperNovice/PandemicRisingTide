package functions;

import cards.CardPlayer;
import model.DiscardPilePlayer;
import model.Players;
import utils.ArrayList;

public enum DiscardCardsSelected {

	INSTANCE;

	public void execute() {

		ArrayList<CardPlayer> list = GetCardsSelectedActivePlayer.INSTANCE.execute();

		for (CardPlayer cardPlayer : list) {

			cardPlayer.deselect();

			Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().remove(cardPlayer);
			DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);

		}

		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();

	}

}
