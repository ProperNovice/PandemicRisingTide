package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;

public class ChooseDiscardCardPlayEvent extends GameState {

	@Override
	public void execute() {

		EAction.CHOOSE_EVENT_TO_PLAY.showAndSelect();
		EAction.CHOOSE_CARD_TO_DISCARD.showAndSelect();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		Class<? extends GameState> classObject = null;

		if (eAction.equals(EAction.CHOOSE_EVENT_TO_PLAY))
			classObject = ActionChooseEventToPlay.class;
		else if (eAction.equals(EAction.CHOOSE_CARD_TO_DISCARD))
			classObject = ChooseCardToDiscardForOverCapacity.class;

		getFlow().addFirst(classObject);
		proceedToNextGameState();

	}

}
