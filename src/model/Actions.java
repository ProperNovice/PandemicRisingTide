package model;

import business.Action;
import controller.Credentials;
import enums.EAction;
import utils.HashMap;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.ShutDown;
import utils.Vector2;

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

	public void selectAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (this.list.getArrayList().contains(action))
			this.hashMap.getValue(eAction).setSelected();
		else
			ShutDown.INSTANCE.execute();

	}

	public void deselectAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (this.list.getArrayList().contains(action))
			this.hashMap.getValue(eAction).deselect();
		else
			ShutDown.INSTANCE.execute();

	}

	public void concealActions() {

		for (Action action : this.list) {

			action.getImageView().setVisible(false);

			if (action.isSelected())
				action.reverseSelected();

		}

		this.list.getArrayList().clear();

	}

	public EAction getEActionPressed(Vector2 vector2) {

		EAction eAction = null;

		for (Action action : this.list)
			if (action.getImageView().contains(vector2))
				return action.getEAction();

		return eAction;

	}

	public boolean actionIsSelected(EAction eAction) {
		return this.hashMap.getValue(eAction).isSelected();
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
