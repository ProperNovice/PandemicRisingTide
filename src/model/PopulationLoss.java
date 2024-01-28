package model;

import business.PopulationCube;
import business.PopulationLossImageView;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;

public enum PopulationLoss {

	INSTANCE;

	private PopulationLossImageView populationLossImageView = null;
	private ListImageViewAbles<PopulationCube> list = new ListImageViewAbles<>();

	private PopulationLoss() {

		this.populationLossImageView = new PopulationLossImageView();
		createList();

	}

	public void setVisible(boolean value) {
		this.populationLossImageView.getImageView().setVisible(value);
	}

	public ListImageViewAbles<PopulationCube> getList() {
		return this.list;
	}

	private void createList() {

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList.x = 22
				+ this.populationLossImageView.getImageView().getCoordinatesTopLeftX();
		listCredentials.coordinatesList.y = 60
				+ this.populationLossImageView.getImageView().getCoordinatesTopLeftY();
		listCredentials.gapBetweenComponents.x = 62;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getArrayList().setCapacity(5);

	}

}
