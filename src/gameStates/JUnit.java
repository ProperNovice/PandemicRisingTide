package gameStates;

import gameStatesDefault.GameState;
import utils.CameraView;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);
		CameraView.INSTANCE.setCameraViewingSpot(2);

	}

}
