package gameStates;

import cards.CardDikeFailure;
import enums.EAction;
import gameStatesDefault.GameState;
import model.DeckDikeFailure;
import model.DiscardPileDikeFailure;

public class MajorBreach extends GameState {

	@Override
	public void execute() {
		EAction.MAJOR_BREACH.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		CardDikeFailure cardDikeFailure = DeckDikeFailure.INSTANCE.removeLast();
		DiscardPileDikeFailure.INSTANCE.addFirstRelocate(cardDikeFailure);
		proceedToNextGameState();

	}

}
