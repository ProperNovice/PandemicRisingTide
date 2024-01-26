package enums;

import model.Actions;

public enum EAction {

	WATER_FLOWS, DIKES_FAIL, CHOOSE_WATER_PUMP, PUMP_WATER, MOVE, CHOOSE_CARD_TO_DISCARD,
	BUILD_DIKE, BUILD_PUMPING_STATION, BUILD_PORT, SHARE_RESOURCES, GIVE_REGION_CARD,
	TAKE_REGION_CARD, BUILD_HYDRAULIC_STRUCTURE, DRAW_CARD_DIKE_FAILURE, DRAW_CARD_PLAYER,
	TAKE_CURRENT_REGION_CARD_FROM_THE_DISCARD_PILE, MOVE_PASSIVE_PLAYER, RESOLVE_EVENT, ARROWS_UP,
	ARROWS_DOWN, FLOOD, STORM, START_GAME, SEA_LEVELS_RISE, WHEN_IT_RAINS_IT_POURS, MAJOR_BREACH,
	CHOOSE_EVENT_TO_PLAY, ADD_POPULATION, OBJECTIVE;

	public void show() {
		Actions.INSTANCE.showAction(this);
	}

	public void showAndSelect() {

		show();
		Actions.INSTANCE.selectAction(this);

	}

}
