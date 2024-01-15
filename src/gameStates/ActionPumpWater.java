package gameStates;

import enums.ERole;
import gameStatesDefault.GameState;
import model.Players;

public class ActionPumpWater extends GameState {

	@Override
	public void execute() {

		getFlow().addFirst(ActionPumpWaterFromActiveRegion.class);

		ERole eRole = Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst()
				.getERole();

		if (eRole.equals(ERole.PUMP_OPERATOR))
			getFlow().addFirst(ActionPumpWaterFromActiveOrAdjacentRegion.class);

		proceedToNextGameState();

	}

}
