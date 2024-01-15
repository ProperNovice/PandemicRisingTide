package resolveEvents;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.BuildDike;
import functions.BuildPumpingStation;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Dikes;
import model.PumpingStations;

public class ResolveEventStoomgemaalVierNoorderKoggen extends GameState {

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();
		setUpRegions();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		handlePumpingStation(eRegion);
		handleDikeLocation(eRegion);

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		BuildDike.INSTANCE.execute(dikeLocation);
		proceed();

	}

	private void handleDikeLocation(ERegion eRegion) {

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty()) {
			proceed();
			return;
		}

		for (Adjacency adjacency : Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion)) {

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation == null)
				continue;

			dikeLocation.setSelected();

		}

	}

	private void handlePumpingStation(ERegion eRegion) {

		if (PumpingStations.INSTANCE.getList().getArrayList().isEmpty())
			return;

		if (!eRegion.getRegion().getPumpingStation().getArrayList().isEmpty())
			return;

		BuildPumpingStation.INSTANCE.executeFromReserve(eRegion);

	}

	private void setUpRegions() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			region.setSelected();

		}

	}

	private void proceed() {

		Actions.INSTANCE.concealActions();
		proceedToNextGameState();

	}

}
