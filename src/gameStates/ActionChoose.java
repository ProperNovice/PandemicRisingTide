package gameStates;

import enums.EAction;
import functions.SetActionsAvailable;
import gameStatesDefault.GameState;
import utils.HashMap;

public class ActionChoose extends GameState {

	private HashMap<EAction, Class<? extends GameState>> hashMap = new HashMap<>();

	@Override
	public void execute() {

		createHashMap();
		SetActionsAvailable.INSTANCE.execute();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		getFlow().addFirst(this.hashMap.getValue(eAction));
		proceedToNextGameState();

	}

	private void createHashMap() {

		this.hashMap.put(EAction.MOVE, ActionChooseMoveToRegion.class);
		this.hashMap.put(EAction.PUMP_WATER, ActionPumpWaterFromPlayerActiveRegion.class);
		this.hashMap.put(EAction.BUILD_DIKE, ActionBuildDike.class);
		this.hashMap.put(EAction.BUILD_PUMPING_STATION, ActionBuildPumpingStation.class);

	}

}
