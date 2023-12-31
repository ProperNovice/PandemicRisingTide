package model;

import business.Port;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;

public enum Ports {

	INSTANCE;

	private ListImageViewAbles<Port> list = new ListImageViewAbles<>();

	private Ports() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cPorts;
		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list
				.getListCredentials().listQuantityRatioImageViewDimensions = Credentials.INSTANCE.dPort.y
						/ 2;
		this.list.getListCredentials().showListSize = true;

		for (int counter = 1; counter <= 5; counter++)
			this.list.getArrayList().addLast(new Port());

		this.list.relocateImageViews();

	}

	public ListImageViewAbles<Port> getList() {
		return this.list;
	}

}
