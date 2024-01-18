package resolveEvents;

import cards.CardPlayer;
import enums.EAction;
import gameStatesDefault.GameState;
import model.Cards;
import model.DeckPlayer;
import model.DeckPlayerPanel;
import utils.ArrayList;

public class ResolveEventTheCalmBeforeTheStorm extends GameState {

	@Override
	public void execute() {

		ArrayList<CardPlayer> card = Cards.INSTANCE.getCardsPlayerRegionClone();
		DeckPlayer.INSTANCE.addDeckShuffleRelocate(card);

		EAction.RESOLVE_EVENT.showAndSelect();

		for (int counter = 1; counter <= 5; counter++) {

			if (DeckPlayer.INSTANCE.isEmpty())
				break;

			DeckPlayerPanel.INSTANCE.getList().getArrayList()
					.addLast(DeckPlayer.INSTANCE.removeFirstFlip());

		}

		DeckPlayerPanel.INSTANCE.getList().relocateImageViews();

	}

}
