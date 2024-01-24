package model;

import cards.CardObjective;
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

		createList();
		createObjectives();

	}

	public void setUpObjectives(int amount) {

		for (EColor eColor : EColor.values())
			this.hashMap.getValue(eColor).loadOriginal();

		this.list.getArrayList().clear();

		ArrayList<EColor> eColors = new ArrayList<>(EColor.values());
		eColors.shuffle();
		eColors.saveOriginal();

		while (this.list.getArrayList().size() < amount) {

			if (eColors.isEmpty())
				eColors.loadOriginal();

			EColor eColor = eColors.removeFirst();
			CardObjective cardObjective = this.hashMap.getValue(eColor).removeRandom();
			this.list.getArrayList().addLast(cardObjective);

		}

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

	private void createList() {

	}

}
