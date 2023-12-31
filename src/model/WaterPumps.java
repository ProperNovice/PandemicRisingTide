package model;

import business.WaterPump;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum WaterPumps {

	INSTANCE;

	private ListImageViewAbles<WaterPump> list = new ListImageViewAbles<>();

	private WaterPumps() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cWaterPumps;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list
				.getListCredentials().listQuantityRatioImageViewDimensions = Credentials.INSTANCE.dWaterPump.y
						/ 2;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 5; counter++)
			this.list.getArrayList().addLast(new WaterPump());

		this.list.relocateImageViews();

	}

	public ListImageViewAbles<WaterPump> getList() {
		return this.list;
	}

}
