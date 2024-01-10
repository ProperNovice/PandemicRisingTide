package enums;

import model.Actions;

public enum EAction {

	WATER_FLOWS, DIKES_FAIL, CHOOSE_WATER_PUMP, PUMP_WATER, MOVE, CHOOSE_CARD_TO_DISCARD,
	BUILD_DIKE, BUILD_PUMPING_STATION, BUILD_PORT;

	public void show() {
		Actions.INSTANCE.showAction(this);
	}

	public void showAndSelect() {

		show();
		Actions.INSTANCE.selectAction(this);

	}

}
