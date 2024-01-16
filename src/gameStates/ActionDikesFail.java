package gameStates;

import gameStatesDefault.GameState;
import model.SeaLevel;

public class ActionDikesFail extends GameState {

	@Override
	public void execute() {

		int cardsToDraw = SeaLevel.INSTANCE.getSeaLevel();

		for (int counter = 1; counter <= cardsToDraw; counter++)
			getFlow().addAllFirst(DrawCardDikeFailure.class, DegradeRegionWithFlood.class);

		proceedToNextGameState();

	}

}
