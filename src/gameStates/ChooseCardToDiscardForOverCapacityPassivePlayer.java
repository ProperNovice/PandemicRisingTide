package gameStates;

import business.Player;
import model.Players;

public class ChooseCardToDiscardForOverCapacityPassivePlayer
		extends ChooseCardToDiscardForOverCapacity {

	@Override
	protected Player getPlayer() {
		return Players.INSTANCE.getPassivePlayer();
	}

}
