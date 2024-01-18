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

	public void addDeckShuffleRelocate(ArrayList<CardPlayer> list) {

		this.list.getArrayList().clear();
		this.list.getArrayList().addAllFirst(list);

		for (CardPlayer cardPlayer : this.list) {

			cardPlayer.getImageView().flipBack();
			cardPlayer.getImageView().setVisible(false);

		}

		this.list.getArrayList().shuffle();
		this.list.relocateImageViews();

	}

	public boolean isEmpty() {
		return this.list.getArrayList().isEmpty();
	}

	public void addDeckFirst(ArrayList<CardPlayer> list) {

		this.list.getArrayList().addAllFirst(list);

		for (CardPlayer cardPlayer : this.list) {

			cardPlayer.getImageView().flipBack();
			cardPlayer.getImageView().setVisible(false);

		}

		this.list.relocateImageViews();

	}

	public CardPlayer removeFirstFlip() {

		CardPlayer cardPlayer = this.list.getArrayList().removeFirst();
		cardPlayer.getImageView().flipFront();
		cardPlayer.getImageView().setVisible(true);

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
