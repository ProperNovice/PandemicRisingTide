package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.ERegion;
import functions.FDiscardCardFromActivePlayer;
import functions.FGetERegionContainingPawn;
import functions.FPawnMoveToRegion;
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

			FDiscardCardFromActivePlayer.INSTANCE.execute(this.cardPlayerRegionMoveTo);
			FPawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else if (this.cardPlayerRegionMoveFrom != null && this.cardPlayerRegionMoveTo == null) {

			FDiscardCardFromActivePlayer.INSTANCE.execute(this.cardPlayerRegionMoveFrom);
			FPawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
			proceedToNextGameState();

		} else {

			this.cardPlayerRegionMoveFrom.setSelected();
			this.cardPlayerRegionMoveTo.setSelected();
			Actions.INSTANCE.showAction(EAction.CHOOSE_CARD_TO_DISCARD);

		}

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		FDiscardCardFromActivePlayer.INSTANCE.execute(cardPlayer);
		FPawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
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

		this.eRegionMoveFrom = FGetERegionContainingPawn.INSTANCE
				.getERegionContainingActivePlayerPawn();

		this.eRegionMoveTo = FPawnMoveToRegion.INSTANCE.getERegionMoveTo();

	}

}
