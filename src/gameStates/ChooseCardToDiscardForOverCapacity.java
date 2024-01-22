package gameStates;

import business.Player;
import cards.CardPlayer;
import enums.EAction;
import functions.DiscardCardFromPlayer;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;
import utils.SelectImageViewManager;

public class ChooseCardToDiscardForOverCapacity extends GameState {

	private Player player = null;

	@Override
	public void execute() {

		if (Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().isOverCapacity())
			this.player = Players.INSTANCE.getActivePlayer();

		else if (Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList()
				.isOverCapacity())
			this.player = Players.INSTANCE.getPassivePlayer();

		EAction.CHOOSE_CARD_TO_DISCARD.show();

		for (CardPlayer cardPlayer : this.player.getCardsPlayer().getArrayList())
			cardPlayer.setSelected();

	}

	@Override
	protected final void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!cardPlayer.isSelected())
			return;
		
		DiscardCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
		proceed(cardPlayer);

	}

	@Override
	protected final void handleCardPressedPassivePlayer(CardPlayer cardPlayer) {

		if (!cardPlayer.isSelected())
			return;
		
		DiscardCardFromPlayer.INSTANCE.executePassivePlayer(cardPlayer);
		proceed(cardPlayer);

	}

	protected final void proceed(CardPlayer cardPlayer) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

}
