package model;

import cards.CardPlayer;
import controller.Credentials;
import utils.ArrayList;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DeckPlayer {

	INSTANCE;

	private ListImageViewAbles<CardPlayer> list = new ListImageViewAbles<>();

	private DeckPlayer() {
		createList();
	}

	public void addDeckRelocate(ArrayList<CardPlayer> list) {

		this.list.getArrayList().clear();
		this.list.getArrayList().addAllLast(list);

		for (CardPlayer cardPlayer : this.list)
			cardPlayer.getImageView().flipBack();

		this.list.getArrayList().shuffle();
		this.list.relocateImageViews();

	}

	public CardPlayer removeFirstFlip() {

		CardPlayer cardPlayer = this.list.getArrayList().removeFirst();
		cardPlayer.getImageView().flipFront();

		return cardPlayer;

	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cDeckPlayer;
		listCredentials.coordinatesList.addVector2(Credentials.INSTANCE.cMap);
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		listCredentials.showListSize = true;

	}

}
