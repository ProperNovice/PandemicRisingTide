package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;
import utils.HashMap;

public class ActionChoose extends GameState {

	private HashMap<EAction, Class<? extends GameState>> hashMap = new HashMap<>();

	@Override
	public void execute() {

		createHashMap();

		showAndSelectAction(EAction.MOVE);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		getFlow().addFirst(this.hashMap.getValue(eAction));

		proceedToNextGameState();

	}

	private void showAndSelectAction(EAction eAction) {

		Actions.INSTANCE.showAction(eAction);
		Actions.INSTANCE.selectAction(eAction);

	}

	private void createHashMap() {

		this.hashMap.put(EAction.MOVE, ActionChooseMoveToRegion.class);

	}

}
