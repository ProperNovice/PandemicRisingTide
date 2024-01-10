package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.FSelectWaterPumpsAvailableToOperate;
import functions.FSelectWaterRegionsWithWaterPump;
import gameStatesDefault.GameState;
import model.Actions;

public class SelectWaterPumpAvailableToOperate extends GameState {

	@Override
	public void execute() {

		EAction.CHOOSE_WATER_PUMP.show();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		FSelectWaterPumpsAvailableToOperate.INSTANCE.setWaterPumpAlreadyOperated(eRegion);
		FSelectWaterRegionsWithWaterPump.INSTANCE.execute(eRegion);

		proceedToNextGameState();

	}

}
