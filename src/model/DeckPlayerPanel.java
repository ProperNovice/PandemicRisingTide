package model;

import cards.CardPlayer;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum DeckPlayerPanel {

	INSTANCE;

	private ListImageViewAbles<CardPlayer> list = new ListImageViewAbles<>();

	private DeckPlayerPanel() {
		createList();
	}

	public ListImageViewAbles<CardPlayer> getList() {
		return this.list;
	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cCardsDeckPanel;
		listCredentials.coordinatesList.addVector2(Credentials.INSTANCE.cMap);
		listCredentials.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;

	}

}
