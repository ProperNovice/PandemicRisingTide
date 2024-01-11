package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.SelectPumpingStationsAvailableToOperate;
import functions.SelectWaterRegionsWithWaterPump;
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

		SelectPumpingStationsAvailableToOperate.INSTANCE.setWaterPumpAlreadyOperated(eRegion);
		SelectWaterRegionsWithWaterPump.INSTANCE.execute(eRegion);

		proceedToNextGameState();

	}

}
