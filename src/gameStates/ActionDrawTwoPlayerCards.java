package gameStates;

import gameStatesDefault.GameState;

public class ActionDrawTwoPlayerCards extends GameState {

	@Override
	public void execute() {
		getFlow().addFirst(DrawOnePlayerCard.class, 2);
		proceedToNextGameState();
	}

}
