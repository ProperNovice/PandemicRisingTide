package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionChooseMove extends GameState {

	@Override
	public void execute() {

		driveFerry();
		sail();
		charterBoat();
		returnToPort();

	}

	private void returnToPort() {

		showActionAndSelect(EAction.RETURN_TO_PORT);

	}

	private void charterBoat() {

		showActionAndSelect(EAction.CHARTER_BOAT);

	}

	private void sail() {

		showActionAndSelect(EAction.SAIL);

	}

	private void driveFerry() {

		showActionAndSelect(EAction.DRIVE_FERRY);

	}

	private void showActionAndSelect(EAction eAction) {

		Actions.INSTANCE.showAction(eAction);
		Actions.INSTANCE.selectAction(eAction);

	}

}
