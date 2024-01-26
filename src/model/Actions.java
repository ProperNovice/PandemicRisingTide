package model;

import business.Action;
import controller.Credentials;
import enums.EAction;
import utils.HashMap;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Logger;
import utils.ShutDown;
import utils.Vector2;

public enum Actions {

	INSTANCE;

	private HashMap<EAction, Action> hashMap = new HashMap<>();
	private ListImageViewAbles<Action> listLeft = new ListImageViewAbles<>();

	private Actions() {
		create();
	}

	public void showAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (this.listLeft.getArrayList().contains(action)) {

			Logger.INSTANCE.log(action);
			ShutDown.INSTANCE.execute();

		}

		action.getImageView().setVisible(true);

		this.listLeft.getArrayList().addLast(action);
		this.listLeft.relocateImageViews();

	}

	public void selectAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (!this.listLeft.getArrayList().contains(action))
			ShutDown.INSTANCE.execute();

		if (action.isSelected())
			return;

		action.setSelected();

	}

	public void deselectAction(EAction eAction) {

		Action action = this.hashMap.getValue(eAction);

		if (!this.listLeft.getArrayList().contains(action))
			ShutDown.INSTANCE.execute();

		if (!action.isSelected())
			return;

		action.deselect();

	}

	public void concealActions() {

		for (Action action : this.listLeft) {

			action.getImageView().setVisible(false);

			if (action.isSelected())
				action.reverseSelected();

		}

		this.listLeft.getArrayList().clear();

	}

	public EAction getEActionPressed(Vector2 vector2) {

		EAction eAction = null;

		for (Action action : this.listLeft)
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

		// create lists

		ListCredentials listCredentials = null;

		// left

		listCredentials = this.listLeft.getListCredentials();

		listCredentials.coordinatesList = Credentials.INSTANCE.cActionIndicators;
		listCredentials.objectsPerRow = 1;
		listCredentials.gapBetweenComponents.y = Credentials.INSTANCE.dActionIndicator.y;
		this.listLeft.getArrayList().setCapacity(5);

	}

}
