package resolveEvents;

import enums.EAction;
import gameStatesDefault.GameState;

public class ResolveEventMailExchange extends GameState {

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

	}

}
