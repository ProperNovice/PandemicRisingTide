package functions;

import cards.CardPlayer;
import model.DiscardPilePlayer;
import model.Players;
import utils.ArrayList;
import utils.SelectImageViewManager;

public enum DiscardCardsSelected {

	INSTANCE;

	public void execute() {

		ArrayList<CardPlayer> list = GetCardsSelectedActivePlayer.INSTANCE.execute();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		for (CardPlayer cardPlayer : list) {

			Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().remove(cardPlayer);
			DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);

		}

		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();

	}

}
