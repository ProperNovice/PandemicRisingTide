package functions;

import cards.CardPlayer;
import model.DiscardPilePlayer;
import model.Players;

public enum DiscardCardFromActivePlayer {

	INSTANCE;

	public void execute(CardPlayer cardPlayer) {

		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().remove(cardPlayer);
		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();

		DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);

	}

}
