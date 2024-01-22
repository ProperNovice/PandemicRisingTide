package gameStates;

import business.Player;
import model.Players;

public class ChooseCardToDiscardForOverCapacityActivePlayer
		extends ChooseCardToDiscardForOverCapacity {

	@Override
	protected Player getPlayer() {
		return Players.INSTANCE.getActivePlayer();
	}

}
