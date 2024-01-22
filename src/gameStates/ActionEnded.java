package gameStates;

import gameStatesDefault.GameState;
import model.Players;

public class ActionEnded extends GameState {

	@Override
	public void execute() {

		if (Players.INSTANCE.getActivePlayer().getActionsRemaining() > 0)
			getFlow().addAllFirst(ActionChoose.class, ActionEnded.class);

		proceedToNextGameState();

	}

}
