package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import functions.FGetERegionContainingPawn;
import functions.FPawnMoveToRegion;
import gameStatesDefault.GameState;
import model.Players;

public class ChooseCardToDiscardForMoving extends GameState {

	private ERegion eRegionMoveFrom = null, eRegionMoveTo = null;
	private CardPlayerRegion cardPlayerRegionMoveFrom = null, cardPlayerRegionMoveTo = null;

	@Override
	public void execute() {

		setUpERegions();
		addCardsPlayerActive();

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
