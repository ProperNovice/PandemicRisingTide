package model;

import cards.CardDikeFailure;
import controller.Credentials;
import enums.ERegion;
import functions.UpdateDikeFailureCardsDrawnCircle;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DiscardPileDikeFailure {

	INSTANCE;

	private ListImageViewAbles<CardDikeFailure> list = new ListImageViewAbles<>();

	private DiscardPileDikeFailure() {
		createList();
	}

	public void addFirstRelocate(CardDikeFailure cardDikeFailure) {

		this.list.getArrayList().addFirst(cardDikeFailure);
		this.list.relocateImageViews();
		UpdateDikeFailureCardsDrawnCircle.INSTANCE.execute(cardDikeFailure);

	}

	public ERegion getFirstCardERegion() {
		return this.list.getArrayList().getFirst().getERegion();
	}

	public ListImageViewAbles<CardDikeFailure> getList() {
		return this.list;
	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cDiscardPileDikeFailure;
		listCredentials.coordinatesList.addVector2(Credentials.INSTANCE.cMap);
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;

	}

}
