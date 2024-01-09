package gameStates;

import functions.FSelectWaterPumpsAvailableToOperate;
import gameStatesDefault.GameState;

public class ActionOperatePumps extends GameState {

	@Override
	public void execute() {

		FSelectWaterPumpsAvailableToOperate.INSTANCE.execute();

		if (FSelectWaterPumpsAvailableToOperate.INSTANCE.isAvailableWaterPumpToOperate())
			getFlow().addAllFirst(SelectWaterPumpAvailableToOperate.class,
					SelectWaterRegionsWithWaterPump.class, ActionOperatePumps.class);

		proceedToNextGameState();

	}

}
