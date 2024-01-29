package model;

import cards.CardPlayer;
import cards.CardPlayerEvent;
import cards.CardPlayerRegion;
import controller.Credentials;
import enums.EEvent;
import enums.ERegion;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DiscardPilePlayer {

	INSTANCE;

	private ListImageViewAbles<CardPlayer> list = new ListImageViewAbles<>();

	private DiscardPilePlayer() {
		createList();
	}

	public void addFirstRelocate(CardPlayer cardPlayer) {

		this.list.getArrayList().addFirst(cardPlayer);
		this.list.relocateImageViews();

	}

	public EEvent getEEventFirstCard() {

		CardPlayer cardPlayer = this.list.getArrayList().getFirst();
		CardPlayerEvent cardPlayerEvent = (CardPlayerEvent) cardPlayer;

		return cardPlayerEvent.getEEvent();

	}

	public CardPlayer getERegionCard(ERegion eRegion) {
		return this.list.getArrayList().remove(getCardPlayerWithERegion(eRegion));
	}

	public boolean containsERegionCard(ERegion eRegion) {
		return getCardPlayerWithERegion(eRegion) != null;
	}

	public void clear() {
		this.list.getArrayList().clear();
	}

	private CardPlayer getCardPlayerWithERegion(ERegion eRegion) {

		for (CardPlayer cardPlayer : this.list) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!cardPlayerRegion.getERegion().equals(eRegion))
				continue;

			return cardPlayerRegion;

		}

		return null;

	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cDiscardPilePlayer;
		listCredentials.coordinatesList.addVector2(Credentials.INSTANCE.cMap);
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;

	}

}
