package model;

import cards.CardObjective;
import controller.Credentials;
import enums.EColor;
import enums.EObjective;
import enums.ERegion;
import utils.ArrayList;
import utils.HashMap;
import utils.ListImageViewAbles;

public enum Objectives {

	INSTANCE;

	private HashMap<EColor, ArrayList<CardObjective>> hashMap = new HashMap<>();
	private ListImageViewAbles<CardObjective> objectives = new ListImageViewAbles<>();
	private HashMap<EColor, ArrayList<ERegion>> populationERegions = new HashMap<>();

	private Objectives() {
		createObjectives();
		createPopulationERegions();
	}

	public void moveObjectivesLeft() {

		this.objectives.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives
				.clone();
		calculateGapBetweenCardsRelocate();

	}

	public void moveObjectivesRight() {

		this.objectives.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives
				.clone();
		this.objectives
				.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dActionIndicator.x;
		this.objectives
				.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dGapBetweenComponents.x;
		calculateGapBetweenCardsRelocate();

	}

	public ListImageViewAbles<CardObjective> getObjectives() {
		return this.objectives;
	}

	public ArrayList<ERegion> getPopulationERegions(EColor eColor) {
		return this.populationERegions.getValue(eColor).clone();
	}

	private void calculateGapBetweenCardsRelocate() {

		double gapX = 2560;
		gapX -= this.objectives.getListCredentials().coordinatesList.x;
		gapX -= Credentials.INSTANCE.gapBetweenBorders;
		gapX -= Credentials.INSTANCE.dCard.x;
		gapX /= this.objectives.getArrayList().size() - 1;

		this.objectives.getListCredentials().gapBetweenComponents.x = gapX;
		this.objectives.relocateImageViews();

	}

	public void setUpObjectives(int amount) {

		for (EColor eColor : EColor.values())
			this.hashMap.getValue(eColor).loadOriginal();

		for (EColor eColor : EColor.values())
			for (CardObjective cardObjective : this.hashMap.getValue(eColor))
				cardObjective.getImageView().setVisible(false);

		this.objectives.getArrayList().clear();

		ArrayList<EColor> eColors = new ArrayList<>(EColor.values());
		eColors.shuffle();
		eColors.saveOriginal();

		while (this.objectives.getArrayList().size() < amount) {

			if (eColors.isEmpty())
				eColors.loadOriginal();

			EColor eColor = eColors.removeFirst();
			CardObjective cardObjective = this.hashMap.getValue(eColor).removeRandom();
			cardObjective.getImageView().setVisible(true);
			this.objectives.getArrayList().addLast(cardObjective);

		}

		moveObjectivesLeft();

	}

	private void createPopulationERegions() {

		ArrayList<ERegion> list = null;

		// green

		list = new ArrayList<>();
		list.addLast(ERegion.SCHOUWEN_DUIVELAND);
		list.addLast(ERegion.WEST_BRABANT);
		list.addLast(ERegion.LAND_VAN_ALTENA);

		// purple

		list = new ArrayList<>();
		list.addLast(ERegion.NOORDERZIJLVEST);
		list.addLast(ERegion.FRYSLAN);

		// red

		list = new ArrayList<>();
		list.addLast(ERegion.DELFLAND);
		list.addLast(ERegion.VOORNE_PUTTEN);
		list.addLast(ERegion.HOEKSE_WAARD);
		list.addLast(ERegion.VIJFHERELANDEN);

		// yellow

		list = new ArrayList<>();
		list.addLast(ERegion.GELDERSE_VALLEI);
		list.addLast(ERegion.BETUWE);
		list.addLast(ERegion.LAND_VAN_MAAS_EN_WAAL);

	}

	private void createObjectives() {

		for (EColor eColor : EColor.values()) {

			ArrayList<CardObjective> list = new ArrayList<>();
			this.hashMap.put(eColor, list);

			for (EObjective eObjective : EObjective.values())
				list.addLast(new CardObjective(eObjective, eColor));

			this.hashMap.getValue(eColor).saveOriginal();

		}

	}

}
