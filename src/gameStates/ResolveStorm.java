package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import utils.ArrayList;

public class ResolveStorm extends GameState {

	@Override
	public void execute() {
		EAction.STORM.showAndSelect();
	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		ArrayList<Class<? extends GameState>> list = new ArrayList<>();

		list.addLast(SeaLevelsRise.class);
		list.addLast(MajorBreach.class);
		list.addLast(DegradeRegionWithFlood.class, 3);
		list.addLast(WhenItRainsItPours.class);

		getFlow().addAllFirst(list);

		proceedToNextGameState();

	}

}
