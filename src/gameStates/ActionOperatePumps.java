package gameStates;

import functions.SelectPumpingStationsAvailableToOperate;
import gameStatesDefault.GameState;

public class ActionOperatePumps extends GameState {

	@Override
	public void execute() {

		SelectPumpingStationsAvailableToOperate.INSTANCE.execute();

		if (SelectPumpingStationsAvailableToOperate.INSTANCE.isAvailableWaterPumpToOperate())
			getFlow().addAllFirst(SelectWaterPumpAvailableToOperate.class,
					SelectRegionContainingWaterCubeAndPumpingStation.class, ActionOperatePumps.class);

		proceedToNextGameState();

	}

}
