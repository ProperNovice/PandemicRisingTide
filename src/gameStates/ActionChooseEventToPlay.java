package gameStates;

import cards.CardPlayer;
import enums.EAction;
import functions.DiscardCardFromPlayer;
import functions.GetEventsPlayable;
import gameStatesDefault.GameState;
import model.Actions;
import resolveEvents.ResolveEvent;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ActionChooseEventToPlay extends GameState {

	@Override
	public void execute() {

		EAction.CHOOSE_EVENT_TO_PLAY.show();

		ArrayList<CardPlayer> active = GetEventsPlayable.INSTANCE.executeActivePlayer();
		ArrayList<CardPlayer> passive = GetEventsPlayable.INSTANCE.executePassivePlayer();

		for (CardPlayer cardPlayer : active)
			cardPlayer.setSelected();

		for (CardPlayer cardPlayer : passive)
			cardPlayer.setSelected();

		if (active.size() == 1 && passive.isEmpty())
			handleCardPressedActivePlayer(active.getFirst());
		else if (active.isEmpty() && passive.size() == 1)
			handleCardPressedPassivePlayer(passive.getFirst());

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		DiscardCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
		proceed();

	}

	@Override
	protected void handleCardPressedPassivePlayer(CardPlayer cardPlayer) {

		DiscardCardFromPlayer.INSTANCE.executePassivePlayer(cardPlayer);
		proceed();

	}

	private void proceed() {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

		getFlow().addFirst(ResolveEvent.class);
		proceedToNextGameState();

	}

}
