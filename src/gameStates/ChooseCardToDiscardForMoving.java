package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.ERegion;
import functions.DiscardCardFromPlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.MovePawnToRegion;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;
import utils.SelectImageViewManager;

public class ChooseCardToDiscardForMoving extends GameState {

	private ERegion eRegionMoveFrom = null, eRegionMoveTo = null;
	private CardPlayerRegion cardPlayerRegionMoveFrom = null, cardPlayerRegionMoveTo = null;

	@Override
	public void execute() {

		setUpERegions();
		addCardsPlayerActive();

		if (this.cardPlayerRegionMoveFrom == null && this.cardPlayerRegionMoveTo != null) {

			DiscardCardFromPlayer.INSTANCE.executeActivePlayer(this.cardPlayerRegionMoveTo);
			MovePawnToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else if (this.cardPlayerRegionMoveFrom != null && this.cardPlayerRegionMoveTo == null) {

			DiscardCardFromPlayer.INSTANCE.executeActivePlayer(this.cardPlayerRegionMoveFrom);
			MovePawnToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else {

			this.cardPlayerRegionMoveFrom.setSelected();
			this.cardPlayerRegionMoveTo.setSelected();

			EAction.CHOOSE_CARD_TO_DISCARD.show();

		}

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!cardPlayer.isSelected())
			return;

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		DiscardCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
		MovePawnToRegion.INSTANCE.moveToERegionActivePlayer();
		proceedToNextGameState();

	}

	private void addCardsPlayerActive() {

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (cardPlayerRegion.getERegion().equals(this.eRegionMoveFrom))
				if (this.cardPlayerRegionMoveFrom == null)
					this.cardPlayerRegionMoveFrom = cardPlayerRegion;

			if (cardPlayerRegion.getERegion().equals(this.eRegionMoveTo))
				if (this.cardPlayerRegionMoveTo == null)
					this.cardPlayerRegionMoveTo = cardPlayerRegion;

		}

	}

	private void setUpERegions() {

		this.eRegionMoveFrom = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		this.eRegionMoveTo = MovePawnToRegion.INSTANCE.getERegionMoveTo();

	}

}
