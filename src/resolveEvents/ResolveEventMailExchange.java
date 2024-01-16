package resolveEvents;

import cards.CardPlayer;
import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ResolveEventMailExchange extends GameState {

	private ArrayList<CardPlayer> active = new ArrayList<>();
	private ArrayList<CardPlayer> passive = new ArrayList<>();

	@Override
	public void execute() {

		if (Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().size() == 1) {

			CardPlayer cardPlayer = Players.INSTANCE.getActivePlayer().getCardsPlayer()
					.getArrayList().getFirst();

			cardPlayer.setSelected();
			this.active.addLast(cardPlayer);

		}

		if (Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList().size() == 1) {

			CardPlayer cardPlayer = Players.INSTANCE.getPassivePlayer().getCardsPlayer()
					.getArrayList().getFirst();

			cardPlayer.setSelected();
			this.passive.addLast(cardPlayer);

		}

		handleAction();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList()
				.remove(this.active.getFirst());
		Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList()
				.remove(this.passive.getFirst());

		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList()
				.addLast(this.passive.getFirst());
		Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList()
				.addLast(this.active.getFirst());

		Players.INSTANCE.getActivePlayer().getCardsPlayer().relocateImageViews();
		Players.INSTANCE.getPassivePlayer().getCardsPlayer().relocateImageViews();

		proceedToNextGameState();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().size() == 1)
			return;

		handleCardPressedPlayer(this.active, cardPlayer);

	}

	@Override
	protected void handleCardPressedPassivePlayer(CardPlayer cardPlayer) {

		if (Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList().size() == 1)
			return;

		handleCardPressedPlayer(this.passive, cardPlayer);

	}

	private void handleCardPressedPlayer(ArrayList<CardPlayer> list, CardPlayer cardPlayer) {

		cardPlayer.reverseSelected();

		if (list.contains(cardPlayer))
			list.remove(cardPlayer);
		else
			list.addLast(cardPlayer);

		handleAction();

	}

	private void handleAction() {

		Actions.INSTANCE.concealActions();

		if (this.active.size() == 1 && this.passive.size() == 1)
			EAction.RESOLVE_EVENT.showAndSelect();
		else
			EAction.RESOLVE_EVENT.show();

	}

}
