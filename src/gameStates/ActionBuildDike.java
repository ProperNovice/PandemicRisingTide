package gameStates;

import business.DikeLocation;
import enums.EAction;
import functions.BuildDike;
import functions.SetDikeLocationsAvailableToBuild;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionBuildDike extends GameState {

	@Override
	public void execute() {

		EAction.BUILD_DIKE.show();
		SetDikeLocationsAvailableToBuild.INSTANCE.execute();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();
		BuildDike.INSTANCE.execute(dikeLocation);

		proceedToNextGameState();

	}

}
