package model;

import cards.CardObjective;
import controller.Credentials;
import enums.EColor;
import enums.EObjective;
import utils.ArrayList;
import utils.HashMap;
import utils.ListImageViewAbles;

public enum Objectives {

	INSTANCE;

	private HashMap<EColor, ArrayList<CardObjective>> hashMap = new HashMap<>();
	private ListImageViewAbles<CardObjective> list = new ListImageViewAbles<>();

	private Objectives() {
		createObjectives();
	}

	public void moveObjectivesLeft() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives.clone();
		calculateGapBetweenCardsRelocate();

	}

	public void moveObjectivesRight() {

		this.list.getListCredentials().coordinatesList = Credentials.INSTANCE.cObjectives.clone();
		this.list.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dActionIndicator.x;
		this.list
				.getListCredentials().coordinatesList.x += Credentials.INSTANCE.dGapBetweenComponents.x;
		calculateGapBetweenCardsRelocate();

	}

	public ListImageViewAbles<CardObjective> getList() {
		return this.list;
	}

	private void calculateGapBetweenCardsRelocate() {

		double gapX = 2560;
		gapX -= this.list.getListCredentials().coordinatesList.x;
		gapX -= Credentials.INSTANCE.gapBetweenBorders;
		gapX -= Credentials.INSTANCE.dCard.x;
		gapX /= this.list.getArrayList().size() - 1;

		this.list.getListCredentials().gapBetweenComponents.x = gapX;
		this.list.relocateImageViews();

	}

	public void setUpObjectives(int amount) {

		for (EColor eColor : EColor.values())
			this.hashMap.getValue(eColor).loadOriginal();

		for (EColor eColor : EColor.values())
			for (CardObjective cardObjective : this.hashMap.getValue(eColor))
				cardObjective.getImageView().setVisible(false);

		this.list.getArrayList().clear();

		ArrayList<EColor> eColors = new ArrayList<>(EColor.values());
		eColors.shuffle();
		eColors.saveOriginal();

		while (this.list.getArrayList().size() < amount) {

			if (eColors.isEmpty())
				eColors.loadOriginal();

			EColor eColor = eColors.removeFirst();
			CardObjective cardObjective = this.hashMap.getValue(eColor).removeRandom();
			cardObjective.getImageView().setVisible(true);
			this.list.getArrayList().addLast(cardObjective);

		}

		moveObjectivesLeft();

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
