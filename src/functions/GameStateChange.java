package functions;

import business.Player;
import cards.CardObjective;
import gameStates.ChooseCardToDiscardForOverCapacity;
import gameStates.ChooseDiscardCardPlayEvent;
import gameStatesDefault.EndGameWon;
import model.CheckForObjectivesAreCompleted;
import model.Objectives;
import model.Players;
import utils.Flow;

public enum GameStateChange {

	INSTANCE;

	public void execute() {

		checkForObjectivesAreCompleted();
		checkForPlayerHandOverCapacity();

	}

	private void checkForObjectivesAreCompleted() {

		if (!CheckForObjectivesAreCompleted.INSTANCE.get())
			return;

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectivesCurrent())
			if (!cardObjective.isMarked())
				return;

		Flow.INSTANCE.getFlow().clear();
		Flow.INSTANCE.getFlow().addFirst(EndGameWon.class);

	}

	private void checkForPlayerHandOverCapacity() {

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
