package gameStates;

import cards.CardPlayer;
import enums.EAction;
import enums.ERegion;
import functions.AddCardToPlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.PlayerHasCardWithERegion;
import functions.RemoveCardFromPlayer;
import gameStatesDefault.GameState;
import utils.HashMap;

public class ActionShareResources extends GameState {

	private ERegion eRegion = null;
	private boolean canGiveCard, canTakeCard;
	private HashMap<EAction, Runnable> hashMap = new HashMap<>();

	@Override
	public void execute() {

		createHashMap();
		setERegion();
		setBooleans();
		handleOptions();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		this.hashMap.getValue(eAction).run();
	}

	private void giveCard() {

		CardPlayer cardPlayer = RemoveCardFromPlayer.INSTANCE.executeActivePlayer(this.eRegion);
		AddCardToPlayer.INSTANCE.executePassivePlayer(cardPlayer);
		proceedToNextGameState();

	}

	private void takeCard() {

		CardPlayer cardPlayer = RemoveCardFromPlayer.INSTANCE.executePassivePlayer(this.eRegion);
		AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayer);
		proceedToNextGameState();

	}

	private void handleOptions() {

		if (this.canGiveCard && this.canTakeCard) {

			EAction.GIVE_REGION_CARD.showAndSelect();
			EAction.TAKE_REGION_CARD.showAndSelect();

		} else if (this.canGiveCard)
			giveCard();

		else if (this.canTakeCard)
			takeCard();

	}

	private void setBooleans() {

		this.canGiveCard = PlayerHasCardWithERegion.INSTANCE
				.playerActiveHasCardWithERegion(this.eRegion);

		this.canTakeCard = PlayerHasCardWithERegion.INSTANCE
				.playerPassiveHasCardWithERegion(this.eRegion);

	}

	private void setERegion() {

		this.eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

	}

	private void createHashMap() {

		this.hashMap.put(EAction.GIVE_REGION_CARD, () -> giveCard());
		this.hashMap.put(EAction.TAKE_REGION_CARD, () -> takeCard());

	}

}
