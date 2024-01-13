package functions;

import cards.CardPlayer;
import utils.ArrayList;
import utils.SelectImageViewManager;

public enum DiscardCardsSelected {

	INSTANCE;

	public void execute() {

		ArrayList<CardPlayer> list = GetCardsSelectedActivePlayer.INSTANCE.execute();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		for (CardPlayer cardPlayer : list)
			DiscardCardFromActivePlayer.INSTANCE.execute(cardPlayer);

	}

}
