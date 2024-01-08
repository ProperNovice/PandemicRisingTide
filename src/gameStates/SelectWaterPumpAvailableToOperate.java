package gameStates;

import enums.EAction;
import gameStatesDefault.GameState;
import model.Actions;

public class SelectWaterPumpAvailableToOperate extends GameState {

	@Override
	public void execute() {

		Actions.INSTANCE.showAction(EAction.CHOOSE_WATER_PUMP);
		functions.SelectWaterPumpAvailableToOperate.INSTANCE.execute();

	}

}
