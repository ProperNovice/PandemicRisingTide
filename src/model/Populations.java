package model;

import business.PopulationCube;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum Populations {

	INSTANCE;

	private ListImageViewAbles<PopulationCube> list = new ListImageViewAbles<>();

	private Populations() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cPopulation;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 36; counter++)
			this.list.getArrayList().addLast(new PopulationCube());

		this.list.relocateImageViews();

		this.list.getArrayList().saveOriginal();

	}

	public ListImageViewAbles<PopulationCube> getList() {
		return this.list;
	}

}
