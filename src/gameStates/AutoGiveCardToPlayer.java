package gameStates;

import enums.EAction;
import functions.AddCardToPlayer;
import functions.GetEventsPlayable;
import gameStatesDefault.GameState;
import model.Players;

public class AutoGiveCardToPlayer extends GameState {

	@Override
	public void execute() {

		AddCardToPlayer.INSTANCE.getCardTrades().removeFirst().run();

		if (!Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().isOverCapacity()
				&& !Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList()
						.isOverCapacity()) {

			proceedToNextGameState();
			return;

		} else if (GetEventsPlayable.INSTANCE.executeActivePlayer().isEmpty()
				&& GetEventsPlayable.INSTANCE.executePassivePlayer().isEmpty()) {

		}

		EAction.RESOLVE_EVENT.showAndSelect();

	}

}
