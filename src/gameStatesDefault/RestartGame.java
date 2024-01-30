package gameStatesDefault;

import functions.CheckForObjectivesAreCompleted;
import functions.ComponentsWrapUp;
import gameStates.StartGame;
import utils.CameraView;
import utils.Flow;
import utils.SelectImageViewManager;
import utils.TextManager;

public class RestartGame extends GameState {

	@Override
	public void execute() {

		CheckForObjectivesAreCompleted.INSTANCE.set(false);
		TextManager.INSTANCE.concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Flow.INSTANCE.getFlow().clear();
		CameraView.INSTANCE.setCameraViewingSpot(1);
		ComponentsWrapUp.INSTANCE.execute();

		Flow.INSTANCE.executeGameState(StartGame.class);

	}

}
