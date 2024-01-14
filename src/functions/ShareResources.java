package functions;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import enums.ERole;
import model.Players;
import utils.ArrayList;

public enum ShareResources {

	INSTANCE;

	private ArrayList<CardPlayer> cardsActivePlayerCanGive = new ArrayList<>();
	private ArrayList<CardPlayer> cardsPassivePlayerCanGive = new ArrayList<>();
	private ERegion eRegionActivePlayer = null;
	private ERegion eRegionPassivePlayer = null;

	public void execute() {

		this.cardsActivePlayerCanGive.clear();
		this.cardsPassivePlayerCanGive.clear();

		this.eRegionActivePlayer = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();
		this.eRegionPassivePlayer = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnPassive();

		activePlayerGiveCurrentRegion();
		passivePlayerGiveCurrentRegion();
		werehouseManager();

	}

	private void activePlayerGiveCurrentRegion() {

		if (!this.eRegionActivePlayer.equals(this.eRegionPassivePlayer))
			return;

		if (!PlayerHasCardWithERegion.INSTANCE
				.playerActiveHasCardWithERegion(this.eRegionActivePlayer))
			return;

		CardPlayer cardPlayer = PlayerHasCardWithERegion.INSTANCE
				.getPlayerActiveCardWithERegion(this.eRegionActivePlayer);

		if (this.cardsActivePlayerCanGive.contains(cardPlayer))
			return;

		this.cardsActivePlayerCanGive.addLast(cardPlayer);

	}

	private void passivePlayerGiveCurrentRegion() {

		if (!this.eRegionPassivePlayer.equals(this.eRegionActivePlayer))
			return;

		if (!PlayerHasCardWithERegion.INSTANCE
				.playerPassiveHasCardWithERegion(this.eRegionPassivePlayer))
			return;

		CardPlayer cardPlayer = PlayerHasCardWithERegion.INSTANCE
				.getPlayerPassiveCardWithERegion(this.eRegionPassivePlayer);

		if (this.cardsPassivePlayerCanGive.contains(cardPlayer))
			return;

		this.cardsPassivePlayerCanGive.addLast(cardPlayer);

	}

	private void werehouseManager() {

		if (!Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.WEREHOUSE_MANAGER))
			return;

		if (this.eRegionActivePlayer.getRegion().getPort().getArrayList().isEmpty())
			return;

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			if (this.cardsActivePlayerCanGive.contains(cardPlayer))
				return;

			this.cardsActivePlayerCanGive.addLast(cardPlayer);

		}

	}

	public boolean canShareResources() {
		return getCardsActivePlayerCanGive().size() + getCardsPassivePlayerCanGive().size() > 0;
	}

	public ArrayList<CardPlayer> getCardsActivePlayerCanGive() {
		return this.cardsActivePlayerCanGive;
	}

	public ArrayList<CardPlayer> getCardsPassivePlayerCanGive() {
		return this.cardsPassivePlayerCanGive;
	}

}
