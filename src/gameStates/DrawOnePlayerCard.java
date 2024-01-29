package gameStates;

import cards.CardPlayer;
import cards.CardPlayerStorm;
import enums.EAction;
import functions.AddCardToPlayer;
import gameStatesDefault.EndGameLost;
import gameStatesDefault.GameState;
import model.DeckPlayer;
import model.DiscardPilePlayer;
import utils.Flow;

public class DrawOnePlayerCard extends GameState {

	@Override
	public void execute() {
		EAction.DRAW_CARD_PLAYER.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		if (DeckPlayer.INSTANCE.isEmpty()) {

			Flow.INSTANCE.getFlow().clear();
			Flow.INSTANCE.getFlow().addLast(EndGameLost.class);
			return;

		}

		CardPlayer cardPlayer = DeckPlayer.INSTANCE.removeFirst();

		if (cardPlayer instanceof CardPlayerStorm) {

			DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);
			getFlow().addFirst(ResolveStorm.class);

		} else
			AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayer);

		proceedToNextGameState();

	}

}
