package model;

import business.Action;
import controller.Credentials;
import enums.EAction;
import utils.HashMap;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.ShutDown;

public enum Actions {

	INSTANCE;

	private HashMap<EAction, Action> hashMap = new HashMap<>();
	private ListImageViewAbles<Action> list = new ListImageViewAbles<>();

	private Actions() {
		create();
	}

	public void showAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (this.list.getArrayList().contains(action))
			ShutDown.INSTANCE.execute();

		action.getImageView().setVisible(true);

		this.list.getArrayList().addLast(action);
		this.list.relocateImageViews();

	}

	private void create() {

		// create hash map

		for (EAction eAction : EAction.values())
			this.hashMap.put(eAction, new Action(eAction));

		// create list

		ListCredentials listCredentials = this.list.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cActionIndicators;
		listCredentials.objectsPerRow = 1;
		listCredentials.gapBetweenComponents.y = Credentials.INSTANCE.dActionIndicator.y;

	}

}
