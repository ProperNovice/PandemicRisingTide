package model;

import cards.CardDikeFailure;
import controller.Credentials;
import utils.ArrayList;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DeckDikeFailure {

	INSTANCE;

	private ListImageViewAbles<CardDikeFailure> list = new ListImageViewAbles<>();

	private DeckDikeFailure() {
		createList();
	}

	public void addDeckRelocate(ArrayList<CardDikeFailure> list) {

		this.list.getArrayList().addAllLast(list);
		this.list.relocateImageViews();

	}

	public CardDikeFailure removeFirstFlip() {

		CardDikeFailure cardPlayer = this.list.getArrayList().removeFirst();
		cardPlayer.getImageView().flipFront();

		return cardPlayer;

	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cDeckDikeFailure;
		listCredentials.coordinatesList.addVector2(Credentials.INSTANCE.cMap);
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		listCredentials.showListSize = true;

	}

}
