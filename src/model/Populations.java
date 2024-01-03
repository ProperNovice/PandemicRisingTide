package model;

import business.Population;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum Populations {

	INSTANCE;

	private ListImageViewAbles<Population> list = new ListImageViewAbles<>();

	private Populations() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cPopulation;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 36; counter++)
			this.list.getArrayList().addLast(new Population());

		this.list.relocateImageViews();

		this.list.getArrayList().saveOriginal();

	}

	public ListImageViewAbles<Population> getList() {
		return this.list;
	}

}
