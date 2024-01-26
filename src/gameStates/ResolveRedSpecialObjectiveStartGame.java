package gameStates;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.AddWaterToRegion;
import functions.RemoveDike;
import gameStatesDefault.GameState;
import model.Adjacencies;
import utils.ArrayList;

public class ResolveRedSpecialObjectiveStartGame extends GameState {

	private ArrayList<DikeLocation> list = new ArrayList<>();

	@Override
	public void execute() {

		EAction.OBJECTIVE.showAndSelect();

		setupDikesRemaining();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		if (!this.list.isEmpty()) {

			removeDikes();
			EAction.OBJECTIVE.showAndSelect();

		} else {

			addWaterCubes();
			proceedToNextGameState();

		}

	}

	private void addWaterCubes() {

		addWaterCube(ERegion.VOORNE_PUTTEN);
		addWaterCube(ERegion.GOERRE_OVERFLAKKEE);
		addWaterCube(ERegion.SCHOUWEN_DUIVELAND);
		addWaterCube(ERegion.WALCHEREN);
		addWaterCube(ERegion.ZEEUWS_VLAANDEREN);

	}

	private void addWaterCube(ERegion eRegion) {

		Region region = eRegion.getRegion();

		while (region.getWaterCubes().getArrayList().size() < 2)
			AddWaterToRegion.INSTANCE.execute(eRegion);

	}

	private void removeDikes() {

		for (DikeLocation dikeLocation : this.list)
			while (!dikeLocation.isEmpty())
				RemoveDike.INSTANCE.execute(dikeLocation);

		this.list.clear();

	}

	private void setupDikesRemaining() {

		this.list.clear();

		handleDikeLocation(ERegion.VOORNE_PUTTEN);
		handleDikeLocation(ERegion.GOERRE_OVERFLAKKEE);
		handleDikeLocation(ERegion.SCHOUWEN_DUIVELAND);
		handleDikeLocation(ERegion.WALCHEREN);
		handleDikeLocation(ERegion.ZEEUWS_VLAANDEREN);

	}

	private void handleDikeLocation(ERegion eRegion) {

		Adjacency adjacency = Adjacencies.INSTANCE.getAdjecencyBetweenRegions(eRegion,
				ERegion.NOORDZEE);

		DikeLocation dikeLocation = adjacency.getDikeLocation();

		if (dikeLocation.isEmpty())
			return;

		this.list.addLast(dikeLocation);

	}

}
