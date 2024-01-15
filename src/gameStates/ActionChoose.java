package gameStates;

import enums.EAction;
import functions.ActionTakeCurrentRegionCardFromDiscardPile;
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
		this.hashMap.put(EAction.PUMP_WATER, ActionPumpWater.class);
		this.hashMap.put(EAction.BUILD_DIKE, ActionBuildDike.class);
		this.hashMap.put(EAction.BUILD_PUMPING_STATION, ActionBuildPumpingStation.class);
		this.hashMap.put(EAction.BUILD_PORT, ActionBuildPort.class);
		this.hashMap.put(EAction.SHARE_RESOURCES, ActionShareResources.class);
		this.hashMap.put(EAction.BUILD_HYDRAULIC_STRUCTURE, ActionBuildHydraulicStructure.class);
		this.hashMap.put(EAction.TAKE_CURRENT_REGION_CARD_FROM_THE_DISCARD_PILE,
				ActionTakeCurrentRegionCardFromDiscardPile.class);

	}

}
