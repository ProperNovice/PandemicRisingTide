package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.ERegion;
import functions.DiscardCardFromActivePlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.PawnMoveToRegion;
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

			DiscardCardFromActivePlayer.INSTANCE.execute(this.cardPlayerRegionMoveTo);
			PawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else if (this.cardPlayerRegionMoveFrom != null && this.cardPlayerRegionMoveTo == null) {

			DiscardCardFromActivePlayer.INSTANCE.execute(this.cardPlayerRegionMoveFrom);
			PawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else {

			this.cardPlayerRegionMoveFrom.setSelected();
			this.cardPlayerRegionMoveTo.setSelected();

			EAction.CHOOSE_CARD_TO_DISCARD.show();

		}

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		DiscardCardFromActivePlayer.INSTANCE.execute(cardPlayer);
		PawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
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

		this.eRegionMoveTo = PawnMoveToRegion.INSTANCE.getERegionMoveTo();

	}

}
