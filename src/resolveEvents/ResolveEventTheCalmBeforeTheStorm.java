package resolveEvents;

import cards.CardPlayer;
import cards.CardPlayerStorm;
import enums.EAction;
import gameStatesDefault.GameState;
import model.DeckPlayer;
import model.DeckPlayerPanel;
import utils.ArrayList;

public class ResolveEventTheCalmBeforeTheStorm extends GameState {

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.showAndSelect();

		for (int counter = 1; counter <= 5; counter++) {

			if (DeckPlayer.INSTANCE.isEmpty())
				break;

			DeckPlayerPanel.INSTANCE.getList().getArrayList()
					.addLast(DeckPlayer.INSTANCE.removeFirstFlip());

		}

		DeckPlayerPanel.INSTANCE.getList().relocateImageViews();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		ArrayList<CardPlayer> list = DeckPlayerPanel.INSTANCE.getList().getArrayList().clear();

		for (CardPlayer cardPlayer : list.clone())
			if (cardPlayer instanceof CardPlayerStorm)
				list.addLast(list.remove(cardPlayer));

		DeckPlayer.INSTANCE.addDeckFirst(list);
		proceedToNextGameState();

	}

}
