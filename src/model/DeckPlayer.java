package model;

import cards.CardPlayer;
import controller.Credentials;
import utils.ArrayList;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DeckPlayer {

	INSTANCE;

	private ListImageViewAbles<CardPlayer> list = new ListImageViewAbles<>();

	private DeckPlayer() {
		createList();
	}

	public void addDeckRelocate(ArrayList<CardPlayer> list) {

		this.list.getArrayList().addAllLast(list);
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
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.showListSize = true;

	}

}
