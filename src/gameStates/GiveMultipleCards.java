package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import functions.AddCardToPlayer;
import functions.RemoveCardFromPlayer;
import gameStatesDefault.GameState;
import model.Actions;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.SelectImageViewManager;

public class GiveMultipleCards extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.concealActions();

		if (SelectImageViewManager.INSTANCE.getSelectedImageViewAbles().isEmpty())
			EAction.GIVE_REGION_CARD.show();
		else
			EAction.GIVE_REGION_CARD.showAndSelect();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!(cardPlayer instanceof CardPlayerRegion))
			return;

		cardPlayer.reverseSelected();
		execute();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		ArrayList<IImageViewAble> list = SelectImageViewManager.INSTANCE
				.getSelectedImageViewAbles();

		ArrayList<CardPlayer> cards = new ArrayList<>();

		for (IImageViewAble imageViewAble : list)
			cards.addLast((CardPlayer) imageViewAble);

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		for (CardPlayer cardPlayer : cards) {

			RemoveCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
			AddCardToPlayer.INSTANCE.executePassivePlayer(cardPlayer);

		}

		proceedToNextGameState();

	}

}
