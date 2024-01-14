package gameStates;

import business.DikeLocation;
import enums.EAction;
import functions.BuildDike;
import functions.SaveDikeLocationBuilt;
import gameStatesDefault.GameState;
import model.Actions;
import model.Dikes;
import utils.SelectImageViewManager;

public class ActionBuildDikeHydraulicEngineer extends GameState {

	@Override
	public void execute() {

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty()) {

			proceedToNextGameState();
			return;

		}

		EAction.BUILD_DIKE.showAndSelect();
		SaveDikeLocationBuilt.INSTANCE.get().setSelected();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();
		BuildDike.INSTANCE.execute(dikeLocation);

		proceedToNextGameState();

	}

}
