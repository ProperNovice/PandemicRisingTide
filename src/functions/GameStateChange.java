package functions;

import business.Player;
import gameStates.ChooseCardToDiscardForOverCapacity;
import gameStates.ChooseDiscardCardPlayEvent;
import model.Players;
import utils.Flow;

public enum GameStateChange {

	INSTANCE;

	public void execute() {

		checkForObjectivesAreCompleted();
		checkForPlayerHandOvercapacity();

	}

	private void checkForObjectivesAreCompleted() {

	}

	private void checkForPlayerHandOvercapacity() {

		handleActivePlayer();
		handlePassivePlayer();

	}

	private void handleActivePlayer() {
		handlePlayer(Players.INSTANCE.getActivePlayer());
	}

	private void handlePassivePlayer() {
		handlePlayer(Players.INSTANCE.getPassivePlayer());
	}

	private void handlePlayer(Player player) {

		if (!player.getCardsPlayer().getArrayList().isOverCapacity())
			return;

		if (GetEventsPlayable.INSTANCE.executeActivePlayer().isEmpty()
				&& GetEventsPlayable.INSTANCE.executePassivePlayer().isEmpty())
			Flow.INSTANCE.getFlow().addFirst(ChooseCardToDiscardForOverCapacity.class);

		else
			Flow.INSTANCE.getFlow().addFirst(ChooseDiscardCardPlayEvent.class);

	}

}
