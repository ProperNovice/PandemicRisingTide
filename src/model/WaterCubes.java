package model;

import business.WaterCube;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum WaterCubes {

	INSTANCE;

	private ListImageViewAbles<WaterCube> list = new ListImageViewAbles<>();

	private WaterCubes() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cWaterCubes;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 36; counter++)
			this.list.getArrayList().addLast(new WaterCube());

		this.list.relocateImageViews();

		this.list.getArrayList().saveOriginal();

	}

	public ListImageViewAbles<WaterCube> getList() {
		return this.list;
	}

}
