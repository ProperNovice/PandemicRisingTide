package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.BuildPumpingStation;
import functions.DiscardCardFromActivePlayer;
import functions.SelectRegionsContainingPumpingStations;
import gameStatesDefault.GameState;
import model.PumpingStations;

public class ActionBuildPumpingStation extends GameState {

	@Override
	public void execute() {

		DiscardCardFromActivePlayer.INSTANCE.executeCardRegionActivePlayer();

		if (!PumpingStations.INSTANCE.getList().getArrayList().isEmpty()) {

			BuildPumpingStation.INSTANCE.executeFromReserve();
			proceedToNextGameState();

		} else {

			EAction.BUILD_PUMPING_STATION.show();
			SelectRegionsContainingPumpingStations.INSTANCE.execute();

		}

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		BuildPumpingStation.INSTANCE.executeFromAnotherRegion(region);
		proceedToNextGameState();

	}

}
