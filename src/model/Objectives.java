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

	private HashMap<EColor, ArrayList<CardObjective>> objectivesCompleteList = new HashMap<>();
	private ListImageViewAbles<CardObjective> objectivesCurrent = new ListImageViewAbles<>();
	private HashMap<EColor, ArrayList<ERegion>> populationERegions = new HashMap<>();

	private Objectives() {
		createObjectives();
		createPopulationERegions();
	}

	public void relocateObjectivesLeft() {

		this.objectivesCurrent.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives
				.clone();
		calculateGapBetweenCardsRelocate();

	}

	public void relocateObjectivesRight() {

		this.objectivesCurrent.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives
				.clone();
		this.objectivesCurrent
				.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dActionIndicator.x;
		this.objectivesCurrent
				.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dGapBetweenComponents.x;
		calculateGapBetweenCardsRelocate();

	}

	public ListImageViewAbles<CardObjective> getObjectivesCurrent() {
		return this.objectivesCurrent;
	}

	public ArrayList<ERegion> getPopulationERegions(EColor eColor) {
		return this.populationERegions.getValue(eColor).clone();
	}

	private void calculateGapBetweenCardsRelocate() {

		double gapX = 2560;
		gapX -= this.objectivesCurrent.getListCredentials().coordinatesList.x;
		gapX -= Credentials.INSTANCE.gapBetweenBorders;
		gapX -= Credentials.INSTANCE.dCard.x;
		gapX /= this.objectivesCurrent.getArrayList().size() - 1;

		this.objectivesCurrent.getListCredentials().gapBetweenComponents.x = gapX;
		this.objectivesCurrent.relocateImageViews();

	}

	public void setUpObjectives(int amount) {

		for (EColor eColor : EColor.values())
			this.objectivesCompleteList.getValue(eColor).loadOriginal();

		for (EColor eColor : EColor.values())
			for (CardObjective cardObjective : this.objectivesCompleteList.getValue(eColor))
				cardObjective.getImageView().setVisible(false);

		this.objectivesCurrent.getArrayList().clear();

		ArrayList<EColor> eColors = new ArrayList<>(EColor.values());
		eColors.shuffle();
		eColors.saveOriginal();

		while (this.objectivesCurrent.getArrayList().size() < amount) {

			if (eColors.isEmpty())
				eColors.loadOriginal();

			EColor eColor = eColors.removeFirst();
			CardObjective cardObjective = this.objectivesCompleteList.getValue(eColor).removeRandom();
			cardObjective.getImageView().setVisible(true);
			this.objectivesCurrent.getArrayList().addLast(cardObjective);

		}

		relocateObjectivesLeft();

	}

	private void createPopulationERegions() {

		ArrayList<ERegion> list = null;
		EColor eColor = null;

		// green

		eColor = EColor.GREEN;
		list = new ArrayList<>();
		list.addLast(ERegion.SCHOUWEN_DUIVELAND);
		list.addLast(ERegion.WEST_BRABANT);
		list.addLast(ERegion.LAND_VAN_ALTENA);
		this.populationERegions.put(eColor, list);

		// purple

		eColor = EColor.PURPLE;
		list = new ArrayList<>();
		list.addLast(ERegion.NOORDERZIJLVEST);
		list.addLast(ERegion.FRYSLAN);
		this.populationERegions.put(eColor, list);

		// red

		eColor = EColor.RED;
		list = new ArrayList<>();
		list.addLast(ERegion.DELFLAND);
		list.addLast(ERegion.VOORNE_PUTTEN);
		list.addLast(ERegion.HOEKSE_WAARD);
		list.addLast(ERegion.VIJFHERELANDEN);
		this.populationERegions.put(eColor, list);

		// yellow

		eColor = EColor.YELLOW;
		list = new ArrayList<>();
		list.addLast(ERegion.GELDERSE_VALLEI);
		list.addLast(ERegion.BETUWE);
		list.addLast(ERegion.LAND_VAN_MAAS_EN_WAAL);
		this.populationERegions.put(eColor, list);

	}

	private void createObjectives() {

		for (EColor eColor : EColor.values()) {

			ArrayList<CardObjective> list = new ArrayList<>();
			this.objectivesCompleteList.put(eColor, list);

			for (EObjective eObjective : EObjective.values())
				list.addLast(new CardObjective(eObjective, eColor));

			this.objectivesCompleteList.getValue(eColor).saveOriginal();

		}

	}

}
