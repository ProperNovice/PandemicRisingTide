package gameStates;

import enums.ERegion;
import enums.EText;
import gameStatesDefault.GameState;
import model.Regions;
import utils.SelectImageView;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);

		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Regions.INSTANCE.getRegion(ERegion.DELFLAND).setSelected();
		Regions.INSTANCE.getRegion(ERegion.GELDERSE_VALLEI).setSelected();

		SelectImageView q = new SelectImageView();
		q.getImageView().setVisible(true);
		q.getImageView().relocateTopLeft(2000, 100);

	}

}
