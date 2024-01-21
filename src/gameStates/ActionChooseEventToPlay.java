package gameStates;

import cards.CardPlayer;
import enums.EAction;
import functions.GetEventsPlayable;
import gameStatesDefault.GameState;
import utils.ArrayList;

public class ActionChooseEventToPlay extends GameState {

	@Override
	public void execute() {

		EAction.CHOOSE_EVENT_TO_PLAY.show();

		ArrayList<CardPlayer> active = GetEventsPlayable.INSTANCE.executeActivePlayer();
		ArrayList<CardPlayer> passive = GetEventsPlayable.INSTANCE.executePassivePlayer();

		for (CardPlayer cardPlayer : GetEventsPlayable.INSTANCE.executeActivePlayer())
			cardPlayer.setSelected();

		for (CardPlayer cardPlayer : GetEventsPlayable.INSTANCE.executePassivePlayer())
			cardPlayer.setSelected();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

	}

	@Override
	protected void handleCardPressedPassivePlayer(CardPlayer cardPlayer) {

	}

}
