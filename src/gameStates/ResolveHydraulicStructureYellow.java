package gameStates;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.EColor;
import enums.ERegion;
import functions.BuildDike;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Dikes;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ResolveHydraulicStructureYellow extends GameState {

	private int dikesLeftToPlace = 4;
	private ArrayList<DikeLocation> list = new ArrayList<>();

	@Override
	public void execute() {

		createAvailableDikeLocations();
		handleAction();

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();

		this.dikesLeftToPlace--;
		BuildDike.INSTANCE.execute(dikeLocation);

		handleAction();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

	private void handleAction() {

		if (this.dikesLeftToPlace == 0 || Dikes.INSTANCE.getList().getArrayList().isEmpty())
			proceedToNextGameState();

		else
			selectDikeLocationsForYellowRegions();

	}

	private void selectDikeLocationsForYellowRegions() {

		EAction.BUILD_DIKE.showAndSelect();

		for (DikeLocation dikeLocation : this.list)
			dikeLocation.setSelected();

	}

	private void createAvailableDikeLocations() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			EColor eColor = region.getEColor();

			if (eColor == null)
				continue;

			if (!eColor.equals(EColor.YELLOW))
				continue;

			ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

			for (Adjacency adjacency : list) {

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation == null)
					continue;

				if (this.list.contains(dikeLocation))
					continue;

				this.list.addLast(dikeLocation);

			}

		}

	}

}
