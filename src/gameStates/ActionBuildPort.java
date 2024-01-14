package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import enums.ERole;
import functions.BuildPort;
import functions.DiscardCardFromActivePlayer;
import functions.SelectRegionsContainingPorts;
import gameStatesDefault.GameState;
import model.Players;
import model.Ports;

public class ActionBuildPort extends GameState {

	@Override
	public void execute() {

		if (!Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.PORT_MASTER))
			DiscardCardFromActivePlayer.INSTANCE.executeCardRegionActivePlayer();

		if (!Ports.INSTANCE.getList().getArrayList().isEmpty()) {

			BuildPort.INSTANCE.executeFromReserve();
			proceedToNextGameState();

		} else {

			EAction.BUILD_PORT.show();
			SelectRegionsContainingPorts.INSTANCE.execute();

		}

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		BuildPort.INSTANCE.executeFromAnotherRegion(region);
		proceedToNextGameState();

	}

}
