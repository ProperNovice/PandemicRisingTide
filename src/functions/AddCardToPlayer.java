package functions;

import business.Player;
import cards.CardPlayer;
import model.Players;
import utils.ArrayList;

public enum AddCardToPlayer {

	INSTANCE;

	private ArrayList<Runnable> list = new ArrayList<>();

	public void executeActivePlayer(CardPlayer cardPlayer) {
		this.list.addLast(() -> addCardRelocate(cardPlayer, Players.INSTANCE.getActivePlayer()));
	}

	public void executePassivePlayer(CardPlayer cardPlayer) {
		this.list.addLast(() -> addCardRelocate(cardPlayer, Players.INSTANCE.getPassivePlayer()));
	}

	private void addCardRelocate(CardPlayer cardPlayer, Player player) {

		player.getCardsPlayer().getArrayList().addLast(cardPlayer);
		player.getCardsPlayer().relocateImageViews();

	}

	public ArrayList<Runnable> getCardTrades() {
		return this.list;
	}

}
