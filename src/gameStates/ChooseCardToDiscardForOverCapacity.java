package gameStates;

import business.Player;
import cards.CardPlayer;
import enums.EAction;
import functions.DiscardCardFromPlayer;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;
import utils.SelectImageViewManager;

public abstract class ChooseCardToDiscardForOverCapacity extends GameState {

	@Override
	public void execute() {

		EAction.CHOOSE_CARD_TO_DISCARD.show();

		for (CardPlayer cardPlayer : getPlayer().getCardsPlayer().getArrayList())
			cardPlayer.setSelected();

	}

	@Override
	protected final void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!cardPlayer.isSelected())
			return;

		discardCardProceed(cardPlayer);

	}

	@Override
	protected final void handleCardPressedPassivePlayer(CardPlayer cardPlayer) {

		if (!cardPlayer.isSelected())
			return;

		discardCardProceed(cardPlayer);

	}

	protected final void discardCardProceed(CardPlayer cardPlayer) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		if (getPlayer().equals(Players.INSTANCE.getActivePlayer()))
			DiscardCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
		else if (getPlayer().equals(Players.INSTANCE.getPassivePlayer()))
			DiscardCardFromPlayer.INSTANCE.executePassivePlayer(cardPlayer);

		proceedToNextGameState();

	}

	protected abstract Player getPlayer();

}
