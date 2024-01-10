package model;

import business.PumpingStation;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum PumpingStations {

	INSTANCE;

	private ListImageViewAbles<PumpingStation> list = new ListImageViewAbles<>();

	private PumpingStations() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cPumpingStations;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list
				.getListCredentials().listQuantityRatioImageViewDimensions = Credentials.INSTANCE.dPumpingStation.y
						/ 2;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 5; counter++)
			this.list.getArrayList().addLast(new PumpingStation());

		this.list.relocateImageViews();

		this.list.getArrayList().saveOriginal();

	}

	public ListImageViewAbles<PumpingStation> getList() {
		return this.list;
	}

}
