package gameStates;

import enums.EAction;
import functions.ActionTakeCurrentRegionCardFromDiscardPile;
import functions.SetActionsAvailable;
import gameStatesDefault.GameState;
import utils.ArrayList;
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

		ArrayList<Class<? extends GameState>> list = new ArrayList<>();

		Class<? extends GameState> classAction = this.hashMap.getValue(eAction);
		list.addLast(classAction);

		if (!classAction.equals(ActionChooseEventToPlay.class))
			list.addFirst(ActionsRemainingReduce.class);

		getFlow().addAllFirst(list);
		proceedToNextGameState();

	}

	private void createHashMap() {

		this.hashMap.put(EAction.MOVE, ActionChooseMoveToRegion.class);
		this.hashMap.put(EAction.PUMP_WATER, ActionPumpWater.class);
		this.hashMap.put(EAction.BUILD_DIKE, ActionBuildDike.class);
		this.hashMap.put(EAction.BUILD_PUMPING_STATION, ActionBuildPumpingStation.class);
		this.hashMap.put(EAction.BUILD_PORT, ActionBuildPort.class);
		this.hashMap.put(EAction.BUILD_PORT, ActionBuildPort.class);
		this.hashMap.put(EAction.EXPAND_POPULATION, ActionExpandPopulation.class);
		this.hashMap.put(EAction.SHARE_RESOURCES, ActionShareResources.class);
		this.hashMap.put(EAction.BUILD_HYDRAULIC_STRUCTURE, ActionBuildHydraulicStructure.class);
		this.hashMap.put(EAction.TAKE_CURRENT_REGION_CARD_FROM_THE_DISCARD_PILE,
				ActionTakeCurrentRegionCardFromDiscardPile.class);
		this.hashMap.put(EAction.RESOLVE_EVENT, ActionChooseEventToPlay.class);

	}

}
