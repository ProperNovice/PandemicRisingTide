package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;

public abstract class DegradeRegion extends GameState {

	@Override
	public void execute() {
		
		Actions.INSTANCE.showAction(EAction.DEGRADE_REGION);

	}

	protected abstract boolean floodOccurs();

}
