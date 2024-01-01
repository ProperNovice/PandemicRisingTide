package gameStates;

import cards.CardPlayerStorm;
import controller.Credentials;
import gameStatesDefault.GameState;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);
		
		CardPlayerStorm cardPlayerStorm = new CardPlayerStorm();

		cardPlayerStorm.getImageView().relocateTopLeft(1500,
				Credentials.INSTANCE.gapBetweenBorders);
		cardPlayerStorm.getImageView().setVisible(true);

	}

}
