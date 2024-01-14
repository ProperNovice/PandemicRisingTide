package gameStates;

import business.DikeLocation;
import enums.EAction;
import enums.ERole;
import functions.BuildDike;
import functions.SaveDikeLocationBuilt;
import functions.SetDikeLocationsAvailableToBuild;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;

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

		SaveDikeLocationBuilt.INSTANCE.set(dikeLocation);

		if (Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.HYDRAULIC_ENGINEER))
			getFlow().addFirst(ActionBuildDikeHydraulicEngineer.class);

		proceedToNextGameState();

	}

}
