package gameStates;

import cards.CardDikeFailure;
import enums.EAction;
import gameStatesDefault.GameState;
import model.DeckDikeFailure;
import model.DiscardPileDikeFailure;
import utils.ArrayList;

public class WhenItRainsItPours extends GameState {

	@Override
	public void execute() {
		EAction.WHEN_IT_RAINS_IT_POURS.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		ArrayList<CardDikeFailure> list = DiscardPileDikeFailure.INSTANCE.getList().getArrayList()
				.clear();

		list.shuffle();
		DeckDikeFailure.INSTANCE.addDeckFirst(list);

		proceedToNextGameState();

	}

}
