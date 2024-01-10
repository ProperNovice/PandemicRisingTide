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

		Actions.INSTANCE.showAction(EAction.MOVE);
		Actions.INSTANCE.selectAction(EAction.MOVE);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		getFlow().addFirst(this.hashMap.getValue(eAction));
		proceedToNextGameState();

	}

	private void createHashMap() {

		this.hashMap.put(EAction.MOVE, ActionChooseMove.class);

	}

}
