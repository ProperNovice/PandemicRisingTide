package gameStates;

import cards.CardDikeFailure;
import enums.EAction;
import gameStatesDefault.GameState;
import model.DeckDikeFailure;
import model.DiscardPileDikeFailure;

public class DrawCardDikeFailure extends GameState {

	@Override
	public void execute() {
		EAction.DRAW_CARD_DIKE_FAILURE.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		CardDikeFailure cardDikeFailure = DeckDikeFailure.INSTANCE.removeFirst();
		DiscardPileDikeFailure.INSTANCE.addFirstRelocate(cardDikeFailure);
		proceedToNextGameState();

	}

}
