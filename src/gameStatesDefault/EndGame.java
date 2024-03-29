package gameStatesDefault;

import enums.EText;
import functions.CheckForObjectivesAreCompleted;
import utils.Flow;
import utils.SelectImageViewManager;
import utils.TextManager;

public abstract class EndGame extends GameState {

	@Override
	public void execute() {

		CheckForObjectivesAreCompleted.INSTANCE.set(false);
		TextManager.INSTANCE.concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Flow.INSTANCE.getFlow().clear();

		getEText().show();
		EText.RESTART.show();

	}

	@Override
	protected void executeTextOption(EText eText) {
		Flow.INSTANCE.executeGameState(RestartGame.class);
	}

	protected abstract EText getEText();

}
