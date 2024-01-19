package gameStates;

import cards.CardPlayer;
import cards.CardPlayerStorm;
import enums.EAction;
import functions.AddCardToPlayer;
import gameStatesDefault.GameState;
import model.DeckPlayer;
import model.DiscardPilePlayer;

public class DrawOnePlayerCard extends GameState {

	@Override
	public void execute() {
		EAction.DRAW_CARD_PLAYER.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		CardPlayer cardPlayer = DeckPlayer.INSTANCE.removeFirstFlip();

		if (cardPlayer instanceof CardPlayerStorm) {

			DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);
			getFlow().addFirst(ResolveStorm.class);

		} else
			AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayer);

		proceedToNextGameState();

	}

}
