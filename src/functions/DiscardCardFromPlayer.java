package functions;

import business.Player;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import model.DiscardPilePlayer;
import model.Players;
import utils.ArrayList;

public enum DiscardCardFromPlayer {

	INSTANCE;

	public void executeActivePlayer(CardPlayer cardPlayer) {

		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().remove(cardPlayer);
		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();

		DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);

	}

	public void executePassivePlayer(CardPlayer cardPlayer) {

		Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList().remove(cardPlayer);
		Players.INSTANCE.getPassivePlayer().getCardsPlayer().relocateImageViews();

		DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayer);

	}

	public void executeCardRegionActivePlayer() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Player player = Players.INSTANCE.getActivePlayer();

		ArrayList<CardPlayer> list = player.getCardsPlayer().getArrayList().clone();

		for (CardPlayer cardPlayer : list) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!cardPlayerRegion.getERegion().equals(eRegion))
				continue;

			executeActivePlayer(cardPlayer);
			return;

		}

	}

}
