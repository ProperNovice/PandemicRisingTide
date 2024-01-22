package functions;

import business.Player;
import cards.CardPlayer;
import gameStates.AutoGiveCardToPlayer;
import model.Players;
import utils.ArrayList;
import utils.Flow;

public enum AddCardToPlayer {

	INSTANCE;

	private ArrayList<Runnable> list = new ArrayList<>();

	public void executeActivePlayer(CardPlayer cardPlayer) {

		this.list.addLast(() -> addCardRelocate(cardPlayer, Players.INSTANCE.getActivePlayer()));
		Flow.INSTANCE.getFlow().addFirst(AutoGiveCardToPlayer.class);

	}

	public void executePassivePlayer(CardPlayer cardPlayer) {

		this.list.addLast(() -> addCardRelocate(cardPlayer, Players.INSTANCE.getPassivePlayer()));
		Flow.INSTANCE.getFlow().addFirst(AutoGiveCardToPlayer.class);

	}

	private void addCardRelocate(CardPlayer cardPlayer, Player player) {

		player.getCardsPlayer().getArrayList().addLast(cardPlayer);
		player.getCardsPlayer().relocateImageViews();

	}

	public ArrayList<Runnable> getCardTrades() {
		return this.list;
	}

}
