package gameStates;

import cards.CardPlayer;
import enums.EAction;
import functions.AddCardToPlayer;
import functions.RemoveCardFromPlayer;
import functions.ShareResources;
import gameStatesDefault.GameState;
import utils.ArrayList;

public class ActionShareResources extends GameState {

	private ArrayList<CardPlayer> give = new ArrayList<>();
	private ArrayList<CardPlayer> take = new ArrayList<>();

	@Override
	public void execute() {

		this.give.addAllLast(ShareResources.INSTANCE.getCardsActivePlayerCanGive());
		this.take.addAllLast(ShareResources.INSTANCE.getCardsPassivePlayerCanGive());

		if (!this.give.isEmpty() && !this.take.isEmpty()) {

			EAction.GIVE_REGION_CARD.showAndSelect();
			EAction.TAKE_REGION_CARD.showAndSelect();

		} else if (this.give.size() == 1)
			giveRegionCard();

		else if (this.take.size() == 1)
			takeRegionCard();

		else if (this.give.size() > 1) {

			getFlow().addFirst(GiveMultipleCards.class);
			proceedToNextGameState();

		}

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		if (eAction.equals(EAction.GIVE_REGION_CARD)) {

			if (this.give.size() == 1)
				giveRegionCard();

			else if (this.give.size() > 1) {

				getFlow().addFirst(GiveMultipleCards.class);
				proceedToNextGameState();

			}

		} else if (eAction.equals(EAction.TAKE_REGION_CARD))
			takeRegionCard();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

	}

	private void giveRegionCard() {

		RemoveCardFromPlayer.INSTANCE.executeActivePlayer(this.give.getFirst());
		AddCardToPlayer.INSTANCE.executePassivePlayer(this.give.getFirst());

		proceedToNextGameState();

	}

	private void takeRegionCard() {

		RemoveCardFromPlayer.INSTANCE.executePassivePlayer(this.take.getFirst());
		AddCardToPlayer.INSTANCE.executeActivePlayer(this.take.getFirst());

		proceedToNextGameState();

	}

}
