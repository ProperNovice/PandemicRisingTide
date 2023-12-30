package model;

import business.Dike;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.ListImageViewAbles;

public enum Dikes {

	INSTANCE;

	private ListImageViewAbles<Dike> list = new ListImageViewAbles<>();

	private Dikes() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cDikes;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 50; counter++)
			this.list.getArrayList().addLast(new Dike());

		this.list.relocateImageViews();

	}

	public ListImageViewAbles<Dike> getList() {
		return this.list;
	}

}
