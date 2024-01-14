package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import enums.ERole;
import functions.BuildPumpingStation;
import functions.DiscardCardFromActivePlayer;
import functions.SelectRegionsContainingPumpingStations;
import gameStatesDefault.GameState;
import model.Players;
import model.PumpingStations;

public class ActionBuildPumpingStation extends GameState {

	@Override
	public void execute() {

		if (!Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.CARPENTER))
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
