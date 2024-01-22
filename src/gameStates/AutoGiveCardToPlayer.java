package gameStates;

import functions.AddCardToPlayer;
import gameStatesDefault.GameState;

public class AutoGiveCardToPlayer extends GameState {

	@Override
	public void execute() {

		if (!AddCardToPlayer.INSTANCE.getCardTrades().isEmpty()) {

			AddCardToPlayer.INSTANCE.getCardTrades().removeFirst().run();
			getFlow().addFirst(AutoGiveCardToPlayer.class);

		}

		proceedToNextGameState();

	}

}
