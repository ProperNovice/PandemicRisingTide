package resolveEvents;

import business.DikeLocation;
import gameStatesDefault.GameState;
import utils.ArrayList;

public class ResolveEventTweeGebroedersPlugsBreach extends GameState {

	private ArrayList<DikeLocation> list = new ArrayList<>();
	private int dikeLocationsLeft;

	@Override
	public void execute() {

		setUpDikeLocations();

	}

	private void setUpDikeLocations() {

	}

}
