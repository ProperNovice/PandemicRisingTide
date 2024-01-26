package model;

import business.PopulationLossImageView;

public enum PopulationLoss {

	INSTANCE;

	private PopulationLossImageView populationLossImageView = null;

	private PopulationLoss() {

		this.populationLossImageView = new PopulationLossImageView();
		createList();

	}

	public void setVisible(boolean value) {
		this.populationLossImageView.getImageView().setVisible(value);
	}

	private void createList() {

	}

}
