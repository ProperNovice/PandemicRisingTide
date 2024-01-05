package gameStates;

import business.Dike;
import enums.EAction;
import functions.SetDikesAvailableToFail;
import gameStatesDefault.GameState;
import model.Actions;
import utils.SelectImageViewManager;

public abstract class DikesFail extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.DIKES_FAIL);
		SetDikesAvailableToFail.INSTANCE.execute();

		if (!SetDikesAvailableToFail.INSTANCE.dikesAvailableToFail())
			Actions.INSTANCE.selectAction(EAction.DIKES_FAIL);

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Actions.INSTANCE.concealActions();

	}

	@Override
	protected void handleDikeSelectedPressed(Dike dike) {

	}

	protected abstract boolean floodOccurs();

}
