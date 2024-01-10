package gameStates;

import functions.SelectWaterPumpsAvailableToOperate;
import gameStatesDefault.GameState;

public class ActionOperatePumps extends GameState {

	@Override
	public void execute() {

		SelectWaterPumpsAvailableToOperate.INSTANCE.execute();

		if (SelectWaterPumpsAvailableToOperate.INSTANCE.isAvailableWaterPumpToOperate())
			getFlow().addAllFirst(SelectWaterPumpAvailableToOperate.class,
					SelectWaterRegionsWithWaterPump.class, ActionOperatePumps.class);

		proceedToNextGameState();

	}

}
