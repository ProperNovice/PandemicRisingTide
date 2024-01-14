package functions;

import cards.CardPlayer;
import enums.ERegion;
import gameStatesDefault.GameState;
import model.DiscardPilePlayer;
import model.Players;

public class ActionTakeCurrentRegionCardFromDiscardPile extends GameState {

	@Override
	public void execute() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		CardPlayer cardPlayer = DiscardPilePlayer.INSTANCE.getERegionCard(eRegion);
		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().addLast(cardPlayer);
		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();

		proceedToNextGameState();

	}

}
